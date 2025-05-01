package com.example.project.services;

import com.example.project.DTO.AdRoiDTO;
import com.example.project.mappers.AdRoiMapper;
import com.example.project.models.AdCampaign;
import com.example.project.models.AdRoi;
import com.example.project.repos.AdCampaignRepo;
import com.example.project.repos.AdRoiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdRoiService{

    private final AdRoiRepository roiRepo;
    private final AdCampaignRepo campaignRepo;
    private final AdRoiMapper mapper;

    public AdRoiDTO create(AdRoiDTO dto) {
        AdRoi roi = mapper.fromDTO(dto);
        roi.setCampaign(
                campaignRepo.findByName(dto.campaignName()).orElseThrow()
        );
        roi.setRoi(calculateROI(dto.adSpent(), dto.revenueGenerated()));
        return mapper.toDTO(roiRepo.save(roi));
    }

    public AdRoiDTO update(Long id, AdRoiDTO dto) {
        AdRoi roi = roiRepo.findById(id).orElseThrow();
        roi.setAdSpent(dto.adSpent());
        roi.setRevenueGenerated(dto.revenueGenerated());
        roi.setRoi(calculateROI(dto.adSpent(), dto.revenueGenerated()));
        roi.setCampaign(campaignRepo.findByName(dto.campaignName()).orElseThrow());
        return mapper.toDTO(roiRepo.save(roi));
    }

    public void delete(Long id) {
        roiRepo.deleteById(id);
    }

    public List<AdRoiDTO> getAll() {
        return mapper.toDTOs(roiRepo.findAll());
    }

    public AdRoiDTO getById(Long id) {
        return mapper.toDTO(roiRepo.findById(id).orElseThrow());
    }

    private BigDecimal calculateROI(BigDecimal spent, BigDecimal revenue) {
        if (spent == null || spent.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        return revenue.subtract(spent).divide(spent, 2, BigDecimal.ROUND_HALF_UP);
    }
}
