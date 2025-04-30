package com.example.project.services;

import com.example.project.DTO.CreativeDTO;
import com.example.project.mappers.CreativeMapper;
import com.example.project.models.AdCampaign;
import com.example.project.models.Creative;
import com.example.project.repos.AdCampaignRepo;
import com.example.project.repos.CreativeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreativeService {
    private final CreativeRepo creativeRepo;
    private final AdCampaignRepo campaignRepo;
    private final CreativeMapper mapper;

    public CreativeDTO createCreative(CreativeDTO dto) {
        AdCampaign campaign = campaignRepo.findByName(dto.campaignName())
                .orElseThrow(() -> new RuntimeException("Campaign not found: " + dto.campaignName()));
        Creative creative = mapper.dtoToCreative(dto);
        creative.setCampaign(campaign);
        return mapper.creativeToDTO(creativeRepo.save(creative));
    }

    public List<CreativeDTO> getAllCreatives() {
        return mapper.creativesToDTOs(creativeRepo.findAll());
    }

    public List<CreativeDTO> getByCampaign(Long campaignId) {
        return mapper.creativesToDTOs(creativeRepo.findByCampaignId(campaignId));
    }

    public void deleteCreative(Long id) {
        creativeRepo.deleteById(id);
    }

    public CreativeDTO updateCreative(Long id, CreativeDTO dto) {
        Creative creative = creativeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Creative not found"));
        creative.setType(dto.type());
        creative.setContentUrl(dto.contentUrl());
        creative.setIsActive(dto.isActive());
        return mapper.creativeToDTO(creativeRepo.save(creative));
    }
}