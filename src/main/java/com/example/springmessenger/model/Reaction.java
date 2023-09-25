package com.example.springmessenger.model;

import jakarta.persistence.*;

@Entity
@Table(name="reaction")
public class Reaction {
    @Id
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Message member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message message;
}
