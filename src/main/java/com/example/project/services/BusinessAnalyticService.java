package com.example.project.services;

import com.example.project.DTO.BusinessAnalyticDTO;
import com.example.project.mappers.BusinessAnalyticMapper;
import com.example.project.models.BusinessAnalytic;
import com.example.project.repos.AdCampaignRepo;
import com.example.project.repos.BusinessAnalyticRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessAnalyticService {
    private final BusinessAnalyticRepo repository;
    private final AdCampaignRepo campaignRepository;
    private final BusinessAnalyticMapper mapper;

    public BusinessAnalyticDTO create(BusinessAnalyticDTO dto) {
        BusinessAnalytic entity = mapper.toEntity(dto);
        entity.setCampaign(campaignRepository.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDto(repository.save(entity));
    }


    public List<BusinessAnalyticDTO> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public BusinessAnalyticDTO update(Long id, BusinessAnalyticDTO dto) {
        BusinessAnalytic entity = repository.findById(id).orElseThrow();
        entity.setSalesGrowth(dto.salesGrowth());
        entity.setCustomerLoyalty(dto.customerLoyalty());
        entity.setBusinessImpactScore(dto.businessImpactScore());
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
