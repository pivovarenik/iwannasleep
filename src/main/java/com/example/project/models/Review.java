package com.example.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "source")
    private String source;

    @Lob
    @Column(name = "content_text")
    private String contentText;

    @Column(name = "sentiment", length = 50)
    private String sentiment;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}