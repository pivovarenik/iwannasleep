package com.example.project.repos;

import com.example.project.models.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceRepo  extends JpaRepository<Audience, Long> {
}
