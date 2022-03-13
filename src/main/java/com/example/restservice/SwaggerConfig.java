package com.example.restservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import static springfox.documentation.builders.PathSelectors.regex;
/**
 * Swagger documentation for the assignment
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.example.restservice" ) )
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata());
    }
    private ApiInfo metadata() {
        return new ApiInfoBuilder().title("Spring Boot Rest API").
                description("Garage Management API")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html#/")
                .contact(new Contact("Amiel Lejzor", "", "Amiel349@gmail.com"))
                .version("1.0").build();
    }


}