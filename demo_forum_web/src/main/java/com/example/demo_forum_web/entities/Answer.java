package com.example.demo_forum_web.entities;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="answer")
@Data

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false)
    private boolean usefull;

    private LocalDateTime createDate;

    @Column(length = 1024)
    private String code;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_topic")
    private Topic topic;

    public String displayParsedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd.MM.yyyy");
        return this.createDate.format(formatter);
    }
}
