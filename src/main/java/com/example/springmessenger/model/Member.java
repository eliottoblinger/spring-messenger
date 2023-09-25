package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="message_member")
public class Member {
    @Id
    private Long id;

    private String customName;

    @ManyToMany
    private Set<Group> groups;

    @OneToMany(mappedBy = "member")
    private Set<MemberMessageView> membersViews = new HashSet<MemberMessageView>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<MemberMessageView> getMembersViews() {
        return membersViews;
    }

    public void setMembersViews(Set<MemberMessageView> membersViews) {
        this.membersViews = membersViews;
    }
}