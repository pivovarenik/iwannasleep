package com.example.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ad_roi")
public class AdRoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private AdCampaign campaign;

    @Column(name = "ad_spent", precision = 15, scale = 2)
    private BigDecimal adSpent;

    @Column(name = "revenue_generated", precision = 15, scale = 2)
    private BigDecimal revenueGenerated;

    @Column(name = "roi", precision = 10, scale = 2)
    private BigDecimal roi;

}