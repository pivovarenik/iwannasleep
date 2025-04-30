package com.example.project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "audience")
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private AdCampaign campaign;

    @Column(name = "segment_name")
    private String segmentName;

    @Column(name = "age_range", length = 50)
    private String ageRange;

    @Column(name = "gender", length = 50)
    private String gender;

    @Column(name = "engagement_score", precision = 5, scale = 2)
    private BigDecimal engagementScore;

}