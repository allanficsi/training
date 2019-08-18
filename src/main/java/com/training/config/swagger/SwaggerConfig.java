package com.training.config.swagger;

import com.training.model.usuario.entity.Usuario;
import java.util.Arrays;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig
{
    public Docket trainingApp()
    {
        return new Docket(DocumentationType.SWAGGER_2)//tipo de documento
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.training"))//apatir de qual pacote ele deve comecar a ler as api's
                .paths(PathSelectors.ant("/**"))//quais os end-poits deven ser documentados, nesse caso todos ex("/api/auth")
                .build()
                .ignoredParameterTypes(Usuario.class)//ignorar a class usuario já qu possui informacoes como o secret do jwt
                .globalOperationParameters(
            Arrays.asList(new ParameterBuilder()
                    .name("Authorization")
                    .description("Header para token JWT")
                    .modelRef(new ModelRef("string"))//tipo do prametro, o token jwt é uma string
                    .parameterType("header")//esse prametro vai no cabeçalho da requisicao
                    .required(true)
                    .build()));
    }
}
