package com.example.apigatewayservice.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static  List<String> openApiEndpoints = new ArrayList<>(Arrays.asList("/auth/login","/user"));
    public static  List<String> adminApiEndpoints = new ArrayList<>(Arrays.asList("/user/admin","/import"));
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
    public Predicate<ServerHttpRequest> AdminRequired =
            request -> adminApiEndpoints.stream().anyMatch(uri -> request.getURI().getPath().contains(uri));


}