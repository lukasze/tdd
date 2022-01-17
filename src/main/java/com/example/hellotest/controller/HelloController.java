package com.example.hellotest.controller;

import com.example.hellotest.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String service;

    @GetMapping("/hello")
    Response greet(@RequestParam(required = false, defaultValue = "World") String name) {
        var message=  "Hello, " + name + "!";
        return new Response(message, service);
    }
}
