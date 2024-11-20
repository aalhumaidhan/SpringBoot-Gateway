package com.example.Gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("MicroserviceStock", r -> r
                        .path("/api/addItems/**")
                        .uri("http://localhost:8080/"))
                .route("Microservice", r -> r
                        .path("/api/orders/**")
                        .uri("http://localhost:8082/"))
                .route("Account", r -> r
                        .path("/api/account/**")
                        .uri("http://localhost:8084/"))
                .build();
    }
}