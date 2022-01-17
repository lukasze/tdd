package com.example.hellotest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTest {

    @Test
    @DisplayName("GET /hello?name=Lukasz -> HTTP 200, Hello, Lukasz!")
    void helloWithName() {
        fail();
    }

    @Test
    @DisplayName("GET /hello -> HTTP 200, Hello, World!")
    void helloWithoutName() {
        fail();
    }
// scenariusze z problemami

    @Test
    @DisplayName("POST /hello -> 405")
    void helloUsingPOST() {
        fail();
    }

    @Test
    @DisplayName("GET /hello -> HTTP 200, Hello, World!")
    void helloWithNameAndNoValue() {
        fail();
    }

}