package com.example.hellotest.controller;

import com.example.hellotest.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// Podnieś cały kontekst Spring'a przed testem
@SpringBootTest
// Spring - Skonfiguruj mi ziarno MockMvc
@AutoConfigureMockMvc
class HelloControllerTest {


    // Wstrzyknij ziarno
    @Autowired
    // Biblioteka do testowania endpoint'ów aplikacji
    private MockMvc mockMvc;
    @Autowired
    // Mapujemy JSON <-> Java
    private ObjectMapper objectMapper;

    // Andotacja Junit - metoda testowa
    @Test
    // JUnit5 - 'słownomuzyczny' opis testu
    @DisplayName("GET /hello?name=Lukasz -> HTTP 200, Hello, Lukasz!")
    // lombok - zamiast throws Exception
    @SneakyThrows
    void helloWithName() {
        final var mvcResult = mockMvc
                // wyślij żądanie POST /hello
                .perform(get("/hello?name=Lukasz"))
                // lepsze logowanie
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        // zmapuj JSON'a do Javy, kroki:
        // 1 JSON z odpowiedzi
        final var json = mvcResult.getResponse().getContentAsString();
        // 2 JSON -> Java
        final var response = objectMapper.readValue(json, Response.class);

        // then
        assertAll("Nie tak łatwo o dobry opis :)",
                () -> assertEquals("Hello, Lukasz", response.getMessage()),
                () -> assertEquals("Hello Service", response.getService())
        );
    }

    @Test
    @DisplayName("GET /hello -> HTTP 200, Hello, World!")
    void helloWithoutName() {
        fail();
    }
// scenariusze z problemami

    @Test
    @DisplayName("POST /hello -> 405")
    void helloUsingPOST() throws Exception {
        // given: /hello (GET)

        // when
        mockMvc
                // wyślij żądanie POST /hello
                .perform(post("/hello"))
                // lepsze logowanie
                .andDo(print())
        // then
                .andExpect(MockMvcResultMatchers.status().is(405));
    }

    @Test
    @DisplayName("GET /hello -> HTTP 200, Hello, World!")
    void helloWithNameAndNoValue() {
        fail();
    }

    @Test
    void emptyTestIsNoFun() {
        // 99% przypadków - nie zostawiamy pustych testów !
        fail();
    }

}