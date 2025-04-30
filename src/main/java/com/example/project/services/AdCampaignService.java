package com.example.project.services;

import com.example.project.DTO.AdCampaignDTO;
import com.example.project.DTO.TimesDTO;
import com.example.project.mappers.AdCampaignMapper;
import com.example.project.models.AdCampaign;
import com.example.project.repos.AdCampaignRepo;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class AdCampaignService {
    private final AdCampaignRepo repo;
    private final AdCampaignMapper mapper;

    public AdCampaignService(AdCampaignRepo repo, AdCampaignMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public AdCampaignDTO createCampaign(AdCampaignDTO dto) {
        AdCampaign campaign = mapper.toEntity(dto);
        campaign.setId(null);
        return mapper.toDTO(repo.save(campaign));
    }

    public AdCampaignDTO updateCampaign(Long id, AdCampaignDTO dto) {
        AdCampaign existing = repo.findById(id).orElseThrow();
        existing.setName(dto.name);
        existing.setStartDate(dto.startDate);
        existing.setEndDate(dto.endDate);
        existing.setBudget(dto.budget);
        existing.setTargetAudience(dto.targetAudience);
        existing.setStatus(dto.status);
        return mapper.toDTO(repo.save(existing));
    }

    public void deleteCampaign(Long id) {
        repo.deleteById(id);
    }

    public List<AdCampaignDTO> getAllCampaigns() {
        return mapper.toDTOs(repo.findAll());
    }

    public AdCampaignDTO getCampaignById(Long id) {
        return mapper.toDTO(repo.findById(id).orElseThrow());
    }

    public AdCampaignDTO changeStatus(Long id, String status) {
        AdCampaign campaign = repo.findById(id).orElseThrow();
        campaign.setStatus(status);
        return mapper.toDTO(repo.save(campaign));
    }
    public TimesDTO getCampaignTime(Long id){
        AdCampaign campaign = repo.findById(id).orElseThrow();
        TimesDTO times = new TimesDTO();
        times.setEndTime(campaign.getEndDate());
        times.setStartTime(campaign.getStartDate());
        return times;
    }
    public String getTargetAudience(Long id){
        AdCampaign campaign = repo.findById(id).orElseThrow();
        return campaign.getTargetAudience();
    }
}
