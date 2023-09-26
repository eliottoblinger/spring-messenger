package com.example.springmessenger.service;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group){
        return groupRepository.save(group);
    }

    @EntityGraph(attributePaths = "messages")
    public Group getById(Long id){
        return groupRepository.findById(id).orElse(null);
    }

    public void delete(Group group) {
        groupRepository.delete(group);
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
}
