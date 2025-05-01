package com.example.project.DTO;

public record ReputationRiskDTO(
        Long id,
        String riskDescription,
        String source,
        String riskLevel,
        String campaignName
) {}