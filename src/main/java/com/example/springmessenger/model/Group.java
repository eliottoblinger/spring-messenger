package com.example.springmessenger.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="group")
public class Group {
    @Id
    private Long id;

    private String name;

    private Timestamp createdAt;
}