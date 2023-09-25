package com.example.springmessenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message){
        return messageRepository.save(message);
    }

    public Message getById(Long id){
        return messageRepository.findById(id).orElse(null);
    }
}
