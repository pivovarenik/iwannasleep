package com.example.project.mappers;

import com.example.project.DTO.ReputationRiskDTO;
import com.example.project.models.ReputationRisk;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReputationRiskMapper {
    @Mapping(source = "relatedCampaign.name", target = "campaignName")
    ReputationRiskDTO toDTO(ReputationRisk risk);

    @Mapping(target = "relatedCampaign.name", source = "campaignName")
    ReputationRisk toEntity(ReputationRiskDTO dto);

    List<ReputationRiskDTO> toDTOs(List<ReputationRisk> risks);
}