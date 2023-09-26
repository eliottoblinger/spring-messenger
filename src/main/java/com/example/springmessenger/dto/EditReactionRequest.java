package com.example.springmessenger.dto;

import com.example.springmessenger.model.Member;
import com.example.springmessenger.model.Message;

import java.io.Serializable;

public class EditReactionRequest implements Serializable {

    private String content;

    private Member member;

    private Message message;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
