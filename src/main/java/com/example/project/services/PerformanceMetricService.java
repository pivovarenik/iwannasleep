package com.example.project.services;

import com.example.project.DTO.PerformanceMetricDTO;
import com.example.project.mappers.PerformanceMetricMapper;
import com.example.project.models.PerformanceMetric;
import com.example.project.repos.AdCampaignRepo;
import com.example.project.repos.PerformanceMetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceMetricService {
    private final PerformanceMetricRepository repository;
    private final AdCampaignRepo campaignRepository;
    private final PerformanceMetricMapper mapper;

    public PerformanceMetricDTO create(PerformanceMetricDTO dto) {
        PerformanceMetric entity = mapper.toEntity(dto);
        entity.setCampaign(campaignRepository.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDTO(repository.save(entity));
    }

    public List<PerformanceMetricDTO> getAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public PerformanceMetricDTO update(Long id, PerformanceMetricDTO dto) {
        PerformanceMetric entity = repository.findById(id).orElseThrow();
        entity.setImpressions(dto.impressions());
        entity.setClicks(dto.clicks());
        entity.setConversionRate(dto.conversionRate());
        entity.setEngagementRate(dto.engagementRate());
        entity.setCampaign(campaignRepository.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}