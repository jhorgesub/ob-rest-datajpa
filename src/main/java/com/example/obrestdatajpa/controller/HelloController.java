package com.example.obrestdatajpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/saludo")
    public String helloWorld() {
        System.out.println(message);
        return "Hello world!!";
    }
}
