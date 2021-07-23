package com.example.apigatewayservice.config;

import com.example.apigatewayservice.filters.Authfilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {
    @Autowired
    Authfilters authfilters;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("user-service",r->r.path("/user/**").filters(f->f.filter(authfilters)).uri("lb://userservice"))
                .route("sector-service",r->r.path("/sector/**").filters(f->f.filter(authfilters)).uri("lb://sectorservice"))
                .route("import-service",r->r.path("/import/**").filters(f->f.filter(authfilters)).uri("lb://importservice"))
                .route("exchange-service",r->r.path("/stockexchange/**").filters(f->f.filter(authfilters)).uri("lb://exchangeservice"))
                .route("company-service",r->r.path("/company/**").filters(f->f.filter(authfilters)).uri("lb://companyservice"))
                .route("auth-service",r->r.path("/login/**").filters(f->f.filter(authfilters)).uri("lb://authservice"))
                .build();
    }
}
