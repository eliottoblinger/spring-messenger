package com.example.springmessenger.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class EditMessageRequest implements Serializable {
    private String content;
    private Timestamp createdAt;

    public EditMessageRequest() {
    }

    public EditMessageRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
