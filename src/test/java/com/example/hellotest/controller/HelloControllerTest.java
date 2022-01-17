package com.example.hellotest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

// Podnieś cały kontekst Spring'a przed testem
@SpringBootTest
// Spring - Skonfiguruj mi ziarno MockMvc (
@AutoConfigureMockMvc
class HelloControllerTest {


    // Wstrzyknij ziarno
    @Autowired
    // Biblioteka do testowania endpoint'ów aplikacji
    private MockMvc mockMvc;

    // Andotacja Junit - metoda testowa
    @Test
    // JUnit5 - 'słownomuzyczny' opis testu
    @DisplayName("GET /hello?name=Lukasz -> HTTP 200, Hello, Lukasz!")
    void helloWithName() {
        // 99% przypadków - nie zostawiamy pustych testów !
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