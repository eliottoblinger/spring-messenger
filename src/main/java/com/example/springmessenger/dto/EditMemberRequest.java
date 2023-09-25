package com.example.springmessenger.dto;

import com.example.springmessenger.model.Group;
import com.example.springmessenger.model.MemberMessageView;

import java.util.HashSet;
import java.util.Set;

public class EditMemberRequest {
    private String customName;

    private Set<Group> groups;

    private final Set<MemberMessageView> membersViews = new HashSet<MemberMessageView>();;

    public EditMemberRequest() {
    }

    public EditMemberRequest(String customName) {
        this.customName = customName;
    }

    public String getCustomName() {
        return customName;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
