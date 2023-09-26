package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditMessageRequest;
import com.example.springmessenger.model.MemberMessageView;
import com.example.springmessenger.model.Message;
import com.example.springmessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") Long id){
        Message message = messageService.getById(id);

        if(message == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(message);
    }

    @PostMapping("/")
    public ResponseEntity<Message> createMessage(@RequestBody EditMessageRequest request) {
        Message message = new Message();

        message.setContent(request.getContent());
        message.setParent(request.getParent());
        message.setGroup(request.getGroup());
        message.setSender(request.getSender());

        messageService.save(message);

        try {
            return ResponseEntity.created(new URI("/api/messages/" + message.getId())).body(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id){
        Message message = messageService.getById(id);

        if(message == null){
            return ResponseEntity.notFound().build();
        }

        messageService.delete(message);

        return ResponseEntity.noContent().build();
    }
}
