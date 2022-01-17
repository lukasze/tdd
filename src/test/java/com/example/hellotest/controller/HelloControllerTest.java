package com.example.hellotest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTest {

    @Test
    @DisplayName("GET /hello?name=Lukasz -> 200")
    void helloWithName() {
        fail();
    }

    @Test
    @DisplayName("GET /hello -> 200")
    void helloWithoutName() {
        fail();
    }
// scenariusze z problemami

    @Test
    @DisplayName("POST /hello -> 401")
    void helloUsingPOST() {
        fail();
    }

    @Test
    @DisplayName("GET /hello?name -> ?")
    void helloWithNameAndNoValue() {
        fail();
    }

}