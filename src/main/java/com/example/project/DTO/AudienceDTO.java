package com.example.project.DTO;

import java.math.BigDecimal;

public record AudienceDTO(
        Long id,
        String campaignName,
        String segmentName,
        String ageRange,
        String gender,
        BigDecimal engagementScore
) {}