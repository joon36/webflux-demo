package com.example.webfluxdemo;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class NumberRouter {
    @Bean
    public RouterFunction<ServerResponse> route(NumberHandler numberHandler){
        return RouterFunctions.route(
            GET("/numbers").and(accept(MediaType.TEXT_EVENT_STREAM)),
            numberHandler::number
        );
    }
}
