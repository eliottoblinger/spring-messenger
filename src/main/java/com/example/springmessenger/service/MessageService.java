package com.example.springmessenger.service;

import com.example.springmessenger.model.Message;
import com.example.springmessenger.repository.MessageRepository;
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

    public void delete(Message message) {
        messageRepository.delete(message);
    }
}
