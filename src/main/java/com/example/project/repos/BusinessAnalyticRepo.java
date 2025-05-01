package com.example.project.repos;

import com.example.project.models.BusinessAnalytic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAnalyticRepo extends JpaRepository<BusinessAnalytic, Long> {
}
