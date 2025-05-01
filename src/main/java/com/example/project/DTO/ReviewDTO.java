package com.example.project.DTO;

import java.time.LocalDateTime;

public record ReviewDTO(
        Long id,
        String source,
        String contentText,
        String sentiment,
        LocalDateTime createdAt
) {}