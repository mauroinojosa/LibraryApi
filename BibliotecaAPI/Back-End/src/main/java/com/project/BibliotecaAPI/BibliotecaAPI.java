package com.project.BibliotecaAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaAPI {

        @Value("${PORT:8080}")
        private int port;

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaAPI.class, args);
        System.out.println("BibliotecaAPI Application Started");
         System.out.println("PORT: " + System.getenv("PORT"));

    
    }

}
