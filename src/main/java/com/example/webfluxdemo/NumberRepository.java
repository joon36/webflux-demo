package com.example.webfluxdemo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NumberRepository extends ReactiveCrudRepository<Number, Integer> {

    Flux<Number> findNumberByValueGreaterThan(Integer value);
    @Query("SELECT * FROM number WHERE value < :value")
    Flux<Number> findLt(Integer value);
}
