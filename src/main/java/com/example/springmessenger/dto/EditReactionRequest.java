package com.example.springmessenger.dto;

import java.io.Serializable;

public class EditReactionRequest implements Serializable {

    private String content;

    private Long member;

    private Long message;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }
    public Long getMessage() {
        return message;
    }

    public void setMessage(Long message) {
        this.message = message;
    }

}
