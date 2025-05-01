package com.example.project.services;

import com.example.project.DTO.ReputationRiskDTO;
import com.example.project.mappers.ReputationRiskMapper;
import com.example.project.models.ReputationRisk;
import com.example.project.repos.AdCampaignRepo;
import com.example.project.repos.ReputationRiskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReputationRiskService {
    private final ReputationRiskRepo repository;
    private final AdCampaignRepo campaignRepository;
    private final ReputationRiskMapper mapper;

    public ReputationRiskDTO create(ReputationRiskDTO dto) {
        ReputationRisk entity = mapper.toEntity(dto);
        entity.setRelatedCampaign(campaignRepository.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDTO(repository.save(entity));
    }

    public List<ReputationRiskDTO> getAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public ReputationRiskDTO update(Long id, ReputationRiskDTO dto) {
        ReputationRisk entity = repository.findById(id).orElseThrow();
        entity.setRiskDescription(dto.riskDescription());
        entity.setRiskLevel(dto.riskLevel());
        entity.setSource(dto.source());
        entity.setRelatedCampaign(campaignRepository.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
