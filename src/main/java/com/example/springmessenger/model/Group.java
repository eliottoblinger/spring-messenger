package com.example.springmessenger.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="message_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @CreatedDate
    private Date createdAt;

    @OneToMany
    private Set<Message> messages;

    @ManyToMany
    private Set<Member> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}