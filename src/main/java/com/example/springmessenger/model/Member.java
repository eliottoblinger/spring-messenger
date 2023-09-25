package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="member")
public class Member {
    @Id
    private Long id;

    private String customName;

    @ManyToMany
    private Set<Group> groups;

    @OneToMany(mappedBy = "message")
    private Set<MemberMessageView> messagesViews = new HashSet<MemberMessageView>();
}