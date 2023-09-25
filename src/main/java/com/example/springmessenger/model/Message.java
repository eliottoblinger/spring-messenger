

package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="messages")
public class Message {
    @Id
    private Long id;

    private String content;

    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message parent;
}

