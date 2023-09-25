package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditReactionRequest;
import com.example.springmessenger.model.Reaction;
import com.example.springmessenger.service.MessageService;
import com.example.springmessenger.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/reaction")
public class ReactionController {
    @Autowired
    private ReactionService reactionService;
    @Autowired
    private MessageService messageService;
    @GetMapping("/{id}")
    public ResponseEntity<Reaction> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(reactionService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Reaction> createReaction(@RequestBody EditReactionRequest request) {
        Reaction reaction = new Reaction();

        reaction.setContent(request.getContent());
        reaction.setMember(request.getMember());
        reaction.setMessage(request.getMessage());

        try {
            reactionService.save(reaction);
            return ResponseEntity.created(new URI("/api/reaction/" + reaction.getId())).body(reaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
