package com.example.project.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AdCampaignDTO {
    public Long id;
    public String name;
    public LocalDate startDate;
    public LocalDate endDate;
    public BigDecimal budget;
    public String targetAudience;
    public String status;
}
