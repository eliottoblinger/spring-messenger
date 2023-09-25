package com.example.springmessenger.repository;

import com.example.springmessenger.model.MemberMessageView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMessageViewRepository extends JpaRepository<MemberMessageView, Long> {
    MemberMessageView save(MemberMessageView memberMessageView);

    MemberMessageView getById(Long id);
}
