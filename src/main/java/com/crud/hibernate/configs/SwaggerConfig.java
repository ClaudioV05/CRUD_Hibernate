package com.crud.hibernate.configs;

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

/**
 * Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact() {
        return new Contact("Claudiomildo Ventura","https://www.linkedin.com/in/claudiomildoventura/","claudiomildo@hotmail.com");
    }

    private ApiInfoBuilder apiInformation() {
        final String openApiTitle = "Crud Hibernate";
        final String openApiDescription = "About\n" + "These API service is the CRUD using hibernate with the architecture pattern Domain-Driven Design(DDD).";
        final String openApiVersion = "1.0";
        final String openApiTermsOfServiceUrl = "-";
        final String openApiLicense = "application/json";
        final String openApiLicenseUrl = "https://www.linkedin.com/in/claudiomildoventura/";

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title(openApiTitle);
        apiInfoBuilder.description(openApiDescription);
        apiInfoBuilder.version(openApiVersion);
        apiInfoBuilder.termsOfServiceUrl(openApiTermsOfServiceUrl);
        apiInfoBuilder.license(openApiLicense);
        apiInfoBuilder.licenseUrl(openApiLicenseUrl);
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }

    @Bean
    public Docket apiDetail() {
        String packageNameController = "com.crud.hibernate.controllers";
        String produces = "application/json";

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
              .apis(RequestHandlerSelectors.basePackage(packageNameController))
              .paths(PathSelectors.any())
              .build()
              .apiInfo(this.apiInformation().build())
              .consumes(new HashSet<String>(Arrays.asList(produces)))
              .produces(new HashSet<String>(Arrays.asList(produces)));

        return docket;
    }
}