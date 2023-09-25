package com.example.springmessenger.repository;

import com.example.springmessenger.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository  extends JpaRepository<Reaction, Long> {
    Reaction save(Reaction reaction);

    Reaction getById(Long id);
}
