package com.example.springmessenger.repository;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);

    Member getById(Long id);
}
