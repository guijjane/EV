package com.example.projetffspring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ProjetFfSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetFfSpringApplication.class, args);
    }

}
