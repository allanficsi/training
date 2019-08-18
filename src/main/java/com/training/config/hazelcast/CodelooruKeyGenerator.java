package com.training.config.hazelcast;

import java.lang.reflect.Method;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

public class CodelooruKeyGenerator implements KeyGenerator
{

    public Object generate(Object target, Method method, Object... params) {
        return target.getClass().getSimpleName() + "_" + method.getName() + "_"
                + StringUtils.arrayToDelimitedString(params, "_");
    }

}
