package com.example.springmessenger.dto;

import com.example.springmessenger.model.Member;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

public class EditGroupRequest implements Serializable {
    private String name;

    private Set<Member> members;

    private Date createdAt;

    public EditGroupRequest() {
    }

    public EditGroupRequest(String name, Set<Member> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
