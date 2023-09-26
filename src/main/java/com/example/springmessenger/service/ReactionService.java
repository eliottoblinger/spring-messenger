package com.example.springmessenger.service;

import com.example.springmessenger.model.Reaction;
import com.example.springmessenger.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;

    public Reaction save(Reaction reaction){
        return reactionRepository.save(reaction);
    }

    public Reaction getById(Long id){
        return reactionRepository.findById(id).orElse(null);
    }

    public void delete(Reaction reaction) {
        reactionRepository.delete(reaction);
    }
}
