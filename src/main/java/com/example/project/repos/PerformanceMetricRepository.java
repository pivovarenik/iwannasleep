package com.example.project.repos;

import com.example.project.models.PerformanceMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceMetricRepository extends JpaRepository<PerformanceMetric, Long> {}