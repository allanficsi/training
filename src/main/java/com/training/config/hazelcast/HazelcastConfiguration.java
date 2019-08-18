package com.training.config.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration extends CachingConfigurerSupport
{

    @Bean
    public HazelcastInstance hazelcastInstance(){
        Config config = new Config();
        config.setInstanceName("hazelcast-instance")        // hazel case instance name
                .addMapConfig(
                        new MapConfig()                     // create map
                                .setName("topico")
                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(-1));     // cache will be available until it will remove manually. less then 0 means never expired.
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance()); // (3)
    }

    @Bean("codelooruKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new CodelooruKeyGenerator();
    }

}
