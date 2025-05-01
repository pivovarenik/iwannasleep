package com.example.project.services;

import com.example.project.DTO.AudienceDTO;
import com.example.project.mappers.AudienceMapper;
import com.example.project.models.Audience;
import com.example.project.repos.AdCampaignRepo;
import com.example.project.repos.AudienceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceService{
    private final AudienceRepo repository;
    private final AdCampaignRepo campaignRepository;
    private final AudienceMapper mapper;

    public AudienceDTO create(AudienceDTO dto) {
        Audience entity = mapper.toEntity(dto);
        entity.setCampaign(campaignRepository.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDto(repository.save(entity));
    }

    public List<AudienceDTO> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public AudienceDTO update(Long id, AudienceDTO dto) {
        Audience entity = repository.findById(id).orElseThrow();
        entity.setSegmentName(dto.segmentName());
        entity.setAgeRange(dto.ageRange());
        entity.setGender(dto.gender());
        entity.setEngagementScore(dto.engagementScore());
        return mapper.toDto(repository.save(entity));
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
