

package com.example.springmessenger.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String content;

    @CreatedDate
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member sender;

    @OneToMany(mappedBy = "message")
    private Set<MemberMessageView> views = new HashSet<MemberMessageView>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Message getParent() {
        return parent;
    }

    public void setParent(Message parent) {
        this.parent = parent;
    }

    public Member getSender() {
        return sender;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    public Set<MemberMessageView> getViews() {
        return views;
    }

    public void setViews(Set<MemberMessageView> views) {
        this.views = views;
    }
}

