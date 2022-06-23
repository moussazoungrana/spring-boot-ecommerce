package com.ecommerce.spring_ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_name", nullable = false)
    private String name;

    @Column(name = "message_subject", nullable = false)
    private String subject;

    @Column(name = "sender_email", nullable = false, unique = true)
    private String email;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String content;

    public Message(Long id, String name, String subject, String email, String content) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.content = content;
    }

    public Message()
    {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}