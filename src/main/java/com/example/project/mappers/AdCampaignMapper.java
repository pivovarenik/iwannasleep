package com.example.project.mappers;

import com.example.project.DTO.AdCampaignDTO;
import com.example.project.models.AdCampaign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdCampaignMapper {
    AdCampaignMapper INSTANCE = Mappers.getMapper(AdCampaignMapper.class);
    AdCampaignDTO toDTO(AdCampaign campaign);
    AdCampaign toEntity(AdCampaignDTO dto);
    List<AdCampaignDTO> toDTOs(List<AdCampaign> campaigns);
}
