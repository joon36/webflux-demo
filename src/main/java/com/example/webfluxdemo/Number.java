package com.example.webfluxdemo;

public class Number {
    private Integer value;

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

// 1. @Controller
// 2. Router Functions
//    - Handler
//    - Router