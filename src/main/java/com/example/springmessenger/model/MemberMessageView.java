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
    @MapsId("memberId") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @MapsId("messageId")
    @JoinColumn(name = "message_id")
    private Message message;
}
