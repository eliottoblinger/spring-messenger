package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "MemberMessageView")
public class MemberMessageView {
    @EmbeddedId
    private MemberMessageViewPK id;

    private Timestamp viewedAt;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @MapsId("messageId")
    @JoinColumn(name = "message_id")
    private Message message;

    public MemberMessageViewPK getId() {
        return id;
    }

    public void setId(MemberMessageViewPK id) {
        this.id = id;
    }

    public Timestamp getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(Timestamp viewedAt) {
        this.viewedAt = viewedAt;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
