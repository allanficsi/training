package com.training;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport //permite que passar paramentros da urls direto para um objeto pageable, para realizar pesquisas
@EnableCaching // ativa usa de cache
@EnableSwagger2 // habilata o swagger
public class TrainingApplication extends SpringBootServletInitializer
{

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(TrainingApplication.class);
    }

    @Bean
    public ModelMapper getModelMapper(){
         ModelMapper modelMapper = new ModelMapper();
         return modelMapper;
    }

    /**
     * como eu tenho o arquivo ValidationMessages_pt_br.properties que tem os erros que podem acontecer
     * o arquivo messages.properties indica qual mensagem derterminado  erro deve exibir, invés de usar a
     * a padrao que foi definida no arquivo ValidationMessages, o caminho "classpath:messages" diz que o nome do arquivo
     * que tem as mensgens de erro é o 'messages'
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
