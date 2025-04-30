package com.example.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "business_analytics")
public class BusinessAnalytic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private AdCampaign campaign;

    @Column(name = "sales_growth", precision = 10, scale = 2)
    private BigDecimal salesGrowth;

    @Column(name = "customer_loyalty", precision = 10, scale = 2)
    private BigDecimal customerLoyalty;

    @Column(name = "business_impact_score", precision = 10, scale = 2)
    private BigDecimal businessImpactScore;

}