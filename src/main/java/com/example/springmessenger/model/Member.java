package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="messager_member")
public class Member {
    @Id
    private Long id;

    private String customName;

    @ManyToMany
    private Set<Group> groups;

    @ManyToMany()
    private Set<Message> messagesViews;
}