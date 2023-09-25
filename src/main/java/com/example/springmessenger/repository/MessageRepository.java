package com.example.springmessenger.repository;

import com.example.springmessenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Message save(Message message);

    Message getById(Long id);
}
