//package com.example.webfluxdemo;
//
//import java.util.stream.Stream;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@RestController
//public class NumberController {
//
//    @GetMapping(value = "/numbers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Number> numberList() {
//        Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
//
//        return Flux.fromStream(stream)
//            .map(Number::new);
//    }
//
//    @PostMapping("/numbers")
//    public Mono<Number> numberCreate(@RequestBody Mono<Integer> value){
//        return value.map(Number::new);
//    }
//
//}