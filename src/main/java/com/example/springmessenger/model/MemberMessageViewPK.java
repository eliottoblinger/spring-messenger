package com.example.springmessenger.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MemberMessageViewPK implements Serializable {

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "message_id")
    private Long messageId;
}
