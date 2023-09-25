package com.example.springmessenger.service;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.repository.GroupRepository;
import com.example.springmessenger.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public Member getById(Long id){
        return memberRepository.findById(id).orElse(null);
    }
}
