package com.example.project.DTO;

import java.time.LocalDateTime;

public record CreativeDTO(
        Long id,
        String campaignName,
        String type,
        String contentUrl,
        LocalDateTime createdAt,
        Boolean isActive
) { }
