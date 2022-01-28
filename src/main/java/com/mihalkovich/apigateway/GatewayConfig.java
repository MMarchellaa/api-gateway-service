package com.mihalkovich.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("admin-service",
                        route -> route.path("/admin-service/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://admin-service"))
                .build();
    }
}