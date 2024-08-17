package com.tbp.crud.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact() {
        return new Contact("Claudiomildo Ventura","https://www.linkedin.com/in/claudiomildoventura/","claudiomildo@hotmail.com");
    }

    private ApiInfoBuilder apiInformation() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Title - Crud Hibernate");
        apiInfoBuilder.description("About\n" +
                "These API service is the CRUD using hibernate with the architecture pattern Domain-Driven Design(DDD).");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Use term: Open Source");
        apiInfoBuilder.license("License");
        apiInfoBuilder.licenseUrl("https://www.linkedin.com/in/claudiomildoventura/");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }
    @Bean
    public Docket apiDetail() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
              .apis(RequestHandlerSelectors.basePackage("com.tbp.crud.controller"))
              .paths(PathSelectors.any())
              .build()
              .apiInfo(this.apiInformation().build())
              .consumes(new HashSet<String>(Arrays.asList("application/json")))
              .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}