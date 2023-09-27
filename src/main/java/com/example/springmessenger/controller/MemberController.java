package com.example.springmessenger.controller;

import com.example.springmessenger.dto.EditMemberRequest;
import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<List<Member>> getAll(){
        List<Member> members = memberService.getAll();

        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable("id") Long id){
        Member member = memberService.getById(id);

        if(member == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(member);
    }

    @GetMapping("/{id}/groups")
    public ResponseEntity<Set<Group>> getGroupsByMemberId(@PathVariable("id") Long id){
        Set<Group> groups = memberService.getGroupsByMemberId(id);
        if (groups == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }

    @PostMapping("/")
    public ResponseEntity<Member> createMember(@RequestBody EditMemberRequest request) {
        Member member = new Member();

        member.setCustomName(request.getCustomName());

        memberService.save(member);

        try {
            return ResponseEntity.created(new URI("/api/members/" + member.getId())).body(member);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long id){
        Member member = memberService.getById(id);

        if(member == null){
            return ResponseEntity.notFound().build();
        }

        memberService.delete(member);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody EditMemberRequest request) {
        Member member = memberService.getById(id);

        if(member == null){
            return ResponseEntity.notFound().build();
        }

        member.setCustomName(request.getCustomName());

        memberService.save(member);

        return ResponseEntity.ok(member);
    }
}
