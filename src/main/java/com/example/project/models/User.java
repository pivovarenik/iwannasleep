package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    @Column(name = "username", unique = true, length = 100, nullable = false)
    private String username;

    @Lob
    @JsonProperty("passwordHash")
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @JsonProperty("role")
    @Column(name = "role", length = 50, nullable = false)
    private String role;

    @JsonProperty("createdAt")
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonProperty("approved")
    @Column(name = "approved", nullable = false)
    private boolean approved;
}