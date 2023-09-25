package com.example.springmessenger.dto;

import com.example.springmessenger.model.Member;
import com.example.springmessenger.model.Message;

import java.sql.Date;
import java.util.Set;

public class EditMemberMessageViewRequest {
    private String name;

    private Member member;

    private Message message;

    private Date viewedAt;

    public EditMemberMessageViewRequest() {
    }

    public EditMemberMessageViewRequest(Member member, Message message, Date viewedAt) {
        this.member = member;
        this.message = message;
        this.viewedAt = viewedAt;
    }

    public String getName() {
        return name;
    }

    public Member getMember() {
        return member;
    }

    public Message getMessage() {
        return message;
    }

    public Date getViewedAt() {
        return viewedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setViewedAt(Date viewedAt) {
        this.viewedAt = viewedAt;
    }
}
