package com.tbp.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootCrudJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudJpaH2Application.class, args);
	}

}
