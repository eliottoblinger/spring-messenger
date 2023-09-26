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
import java.sql.Date;
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
        group.setCreatedAt(new Date(System.currentTimeMillis()));

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("id") Long id){
        Group group = groupService.getById(id);
        groupService.delete(group);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable("id") Long id, @RequestBody EditGroupRequest request){
        Group group = groupService.getById(id);
        if (request.getName() != null) {
            group.setName(request.getName());
        }
        if (request.getMembers() != null) {
            group.setMembers(request.getMembers());
        }
        groupService.save(group);
        return ResponseEntity.ok(group);
    }
}
