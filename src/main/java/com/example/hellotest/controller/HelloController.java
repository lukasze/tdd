package com.example.hellotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String greet(@RequestParam(required = false, defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}
