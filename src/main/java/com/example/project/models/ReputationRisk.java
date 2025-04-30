package com.example.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reputation_risks")
public class ReputationRisk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "risk_description")
    private String riskDescription;

    @Column(name = "source")
    private String source;

    @Column(name = "risk_level", length = 50)
    private String riskLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "related_campaign_id")
    private AdCampaign relatedCampaign;

}