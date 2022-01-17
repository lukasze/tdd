package com.example.hellotest.respository;

import com.example.hellotest.model.Hobbit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    - wyizolowana warstwa
    - @Transactional
    - rollback po każdym teście
 */
@DataJpaTest
class HobbitRepositoryTest {

    @Autowired
    private HobbitRepository hobbitRepository;

    @Test
    @DisplayName("findAll -> Bilbo & Frodo only")
    void findAll() {
        // given: 2 hobbits in DB

        // when
        final var allHobbitsFromDB = hobbitRepository.findAll();

        // then
        assertAll("Tylko Frodo i Bilbo w bazie danych",
            () -> assertEquals(2, allHobbitsFromDB.size()),
            () -> assertEquals("Frodo", allHobbitsFromDB.get(0).getName()),
            () -> assertEquals("Bilbo", allHobbitsFromDB.get(1).getName())
        );
    }

}