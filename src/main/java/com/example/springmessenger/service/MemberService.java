package com.example.springmessenger.service;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.repository.GroupRepository;
import com.example.springmessenger.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GroupRepository GroupRepository;

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public Member getById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public void delete(Member member) {
        Set<Group> groups = member.getGroups();
        for (Group group : groups) {
            group.getMembers().remove(member);
            if (group.getMembers().size() < 2) {
                GroupRepository.delete(group);
            }
        }
        memberRepository.delete(member);
    }

    public Set<Group> getGroupsByMemberId(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        Set<Group> groups = member.getGroups();
        if (groups.isEmpty()) {
            return null;
        }
        return groups.stream().sorted((g1, g2) -> g2.getId().compareTo(g1.getId())).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
