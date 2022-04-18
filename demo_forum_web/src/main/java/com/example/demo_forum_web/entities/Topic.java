package com.example.demo_forum_web.entities;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name= "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 32)
    private String title;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false,length = 16)
    private String category;

    private LocalDateTime createDate;

    @Column(nullable = false,length = 1024)
    private String code;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @OneToMany(mappedBy = "topic")
    private List<Answer> answer;
}
