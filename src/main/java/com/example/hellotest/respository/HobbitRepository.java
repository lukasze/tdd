package com.example.hellotest.respository;

import com.example.hellotest.model.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbitRepository extends JpaRepository<Hobbit, Long> {

}
