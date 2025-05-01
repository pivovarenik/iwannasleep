package com.example.project.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PerformanceMetricDTO(
        Long id,
        String campaignName,
        Integer impressions,
        Integer clicks,
        BigDecimal conversionRate,
        BigDecimal engagementRate,
        LocalDateTime recordedAt
) {}
