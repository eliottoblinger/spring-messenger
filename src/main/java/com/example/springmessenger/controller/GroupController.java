package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditGroupRequest;
import com.example.springmessenger.dto.EditMessageRequest;
import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.model.Message;
import com.example.springmessenger.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/{id}")
    public ResponseEntity<Group> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(groupService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Group> createGroup(@RequestBody EditGroupRequest request) {
        Group group = new Group();

        group.setName(request.getName());
        group.setMembers(request.getMembers());

        groupService.save(group);

        try {
            return ResponseEntity.created(new URI("/api/groups/" + group.getId())).body(group);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/messages")
    public ResponseEntity<Set<Message>> getMessages(@PathVariable("id") Long id){
        return ResponseEntity.ok(groupService.getById(id).getMessages());
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<Set<Member>> getMember(@PathVariable("id") Long id){
        return ResponseEntity.ok(groupService.getById(id).getMembers());
    }
}
