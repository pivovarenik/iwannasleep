package com.example.project.DTO;

import java.math.BigDecimal;

public record BusinessAnalyticDTO(
        Long id,
        String campaignName,
        BigDecimal salesGrowth,
        BigDecimal customerLoyalty,
        BigDecimal businessImpactScore
) {}