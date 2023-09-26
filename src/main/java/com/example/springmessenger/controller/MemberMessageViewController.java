package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditMemberMessageViewRequest;
import com.example.springmessenger.dto.EditMessageRequest;
import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.model.MemberMessageView;
import com.example.springmessenger.model.Message;
import com.example.springmessenger.service.MemberMessageViewService;
import com.example.springmessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/messages-views")
public class MemberMessageViewController {
    @Autowired
    private MemberMessageViewService memberMessageViewService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberMessageView> getById(@PathVariable("id") Long id){
        MemberMessageView member = memberMessageViewService.getById(id);

        if(member == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(member);
    }

    @PostMapping("/")
    public ResponseEntity<MemberMessageView> createMessage(@RequestBody EditMemberMessageViewRequest request) {
        MemberMessageView memberMessageView = new MemberMessageView();

        memberMessageView.setMember(request.getMember());
        memberMessageView.setMessage(request.getMessage());
        memberMessageView.setViewedAt(request.getViewedAt());

        memberMessageViewService.save(memberMessageView);

        try {
            return ResponseEntity.created(new URI("/api/messages-views/" + memberMessageView.getId())).body(memberMessageView);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
