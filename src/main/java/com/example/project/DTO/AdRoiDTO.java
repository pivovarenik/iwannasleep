package com.example.project.DTO;

import java.math.BigDecimal;

public record AdRoiDTO(
        Long id,
        String campaignName,
        BigDecimal adSpent,
        BigDecimal revenueGenerated,
        BigDecimal roi
) {}
