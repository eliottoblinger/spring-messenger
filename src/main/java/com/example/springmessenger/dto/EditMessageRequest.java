package com.example.springmessenger.dto;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.Member;
import com.example.springmessenger.model.MemberMessageView;
import com.example.springmessenger.model.Message;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class EditMessageRequest implements Serializable {
    private String content;

    private Group group;

    private Message parent;
    private Member sender;
    private Set<MemberMessageView> messagesViews = new HashSet<MemberMessageView>();
    private Timestamp createdAt;

    public EditMessageRequest() {
    }

    public EditMessageRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Group getGroup() {
        return group;
    }

    public Message getParent() {
        return parent;
    }

    public Member getSender() {
        return sender;
    }

    public Set<MemberMessageView> getMessagesViews() {
        return messagesViews;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setParent(Message parent) {
        this.parent = parent;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    public void setMessagesViews(Set<MemberMessageView> messagesViews) {
        this.messagesViews = messagesViews;
    }
}
