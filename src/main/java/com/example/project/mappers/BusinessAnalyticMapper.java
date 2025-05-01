package com.example.project.mappers;

import com.example.project.DTO.BusinessAnalyticDTO;
import com.example.project.models.BusinessAnalytic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessAnalyticMapper {
    @Mapping(source = "campaign.name", target = "campaignName")
    BusinessAnalyticDTO toDto(BusinessAnalytic analytic);

    @Mapping(target = "campaign", ignore = true)
    BusinessAnalytic toEntity(BusinessAnalyticDTO dto);

    List<BusinessAnalyticDTO> toDtoList(List<BusinessAnalytic> list);
}