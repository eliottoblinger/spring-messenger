package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="messager_group")
public class Group {
    @Id
    private Long id;

    private String name;

    private Timestamp createdAt;

    @ManyToMany
    private Set<Member> members;
}