package com.example.project.repos;

import com.example.project.models.AdRoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRoiRepository extends JpaRepository<AdRoi, Long> {
}
