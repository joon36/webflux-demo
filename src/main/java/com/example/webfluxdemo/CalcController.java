package com.example.webfluxdemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CalcController {

    private WebClient webClient;

    public CalcController(WebClient.Builder builder) {
        this.webClient = builder
            .baseUrl("http://localhost:8080")
            .build();
    }

    @GetMapping(value = "/square", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Number> square() {
        return webClient.get()
            .uri("/numbers")
            .retrieve()
            .bodyToFlux(Number.class)
            .map(number -> {
                number.setValue(number.getValue() * number.getValue());
                return number;
            }); // Flux<Number>
    }

    @PostMapping("cube")
    public Mono<Number> cube(@RequestBody Mono<Integer> value) {
        return webClient.post()
            .uri("/numbers")
            .body(value, Integer.class) // Mono or Flux, Serialize class
            .retrieve()
            .bodyToMono(Number.class)
            .map(number -> {
                number.setValue(number.getValue() * number.getValue() * number.getValue());
                return number;
            });
    }


}
// Spring Data R2DBC (Reactive Relational Database Connectivity)
// - Spring MVC + JPA
// - Spring WebFlux + R2DBC