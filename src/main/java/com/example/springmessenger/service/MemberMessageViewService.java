package com.example.springmessenger.service;

import com.example.springmessenger.model.MemberMessageView;
import com.example.springmessenger.repository.MemberMessageViewRepository;
import com.example.springmessenger.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberMessageViewService {
    @Autowired
    private MemberMessageViewRepository memberMessageViewRepository;

    public MemberMessageView save(MemberMessageView memberMessageView){
        return memberMessageViewRepository.save(memberMessageView);
    }

    public MemberMessageView getById(Long id){
        return memberMessageViewRepository.findById(id).orElse(null);
    }
}
