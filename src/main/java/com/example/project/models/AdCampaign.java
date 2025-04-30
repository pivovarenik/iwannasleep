package com.example.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ad_campaigns")
public class AdCampaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    @Column(name = "name", nullable = false, length = 50,unique = true)
    private String name;

    @Column(name = "start_date")
    @JsonProperty(value = "startDate")
    private LocalDate startDate;

    @Column(name = "end_date")
    @JsonProperty(value = "endDate")
    private LocalDate endDate;

    @Column(name = "budget", precision = 15, scale = 2)
    @JsonProperty(value = "budget")
    private BigDecimal budget;

    @Lob
    @Column(name = "target_audience")
    @JsonProperty(value = "target_audience")
    private String targetAudience;

    @Column(name = "status", length = 50)
    @JsonProperty(value = "status")
    private String status;

}