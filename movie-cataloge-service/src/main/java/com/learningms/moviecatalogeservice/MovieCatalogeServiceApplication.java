package com.learningms.moviecatalogeservice;/*
 * @created 17/06/2021 - 3:44 PM
 * @author ASHRIN ROSE JOSE
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogeServiceApplication {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder getWebClientBuilder(){ return WebClient.builder();}

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogeServiceApplication.class, args);
    }
}
