package com.example.project.repos;

import com.example.project.models.Creative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreativeRepo  extends JpaRepository<Creative, Long> {
    List<Creative> findByCampaignId(Long campaignId);
}
