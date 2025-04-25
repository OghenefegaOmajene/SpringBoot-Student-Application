package com.example.studentApp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI studentAPI(){
        return new OpenAPI().info(new Info().title("Student API").version("1.0").description("Student application software"));
    }
}
