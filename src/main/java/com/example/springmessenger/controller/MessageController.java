package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditMessageRequest;
import com.example.springmessenger.model.Message;
import com.example.springmessenger.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(messageService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Message> createMessage(@RequestBody EditMessageRequest request) {
        Message message = new Message();

        message.setContent(request.getContent());

        try {
            return ResponseEntity.created(new URI("/api/messages/" + message.getId())).body(message);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
