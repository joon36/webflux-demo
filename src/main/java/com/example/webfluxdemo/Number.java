package com.example.webfluxdemo;

import org.springframework.data.annotation.Id;

public class Number {
    @Id
    private Integer id;
    private Integer value;

    public Number() {
    }

    public Number(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

// comment.getPost().getId() (X)

// 1. @Controller
// 2. Router Functions
//    - Handler
//    - Router