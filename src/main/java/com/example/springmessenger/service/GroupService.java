package com.example.springmessenger.service;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group){
        return groupRepository.save(group);
    }

    public Group getById(Long id){
        return groupRepository.findById(id).orElse(null);
    }
}
