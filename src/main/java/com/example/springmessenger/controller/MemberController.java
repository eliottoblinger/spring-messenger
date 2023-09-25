package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditMemberRequest;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(memberService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Member> createMessage(@RequestBody EditMemberRequest request) {
        Member member = new Member();

        member.setCustomName(request.getCustomName());

        memberService.save(member);

        try {
            return ResponseEntity.created(new URI("/api/members/" + member.getId())).body(member);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
