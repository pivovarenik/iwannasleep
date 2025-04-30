package com.example.project.repos;

import com.example.project.models.AdCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface AdCampaignRepo extends JpaRepository<AdCampaign, Long> {
    Optional<AdCampaign> findByName(String name);
}
