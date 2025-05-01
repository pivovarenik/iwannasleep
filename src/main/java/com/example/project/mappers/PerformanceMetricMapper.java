package com.example.project.mappers;

import com.example.project.DTO.PerformanceMetricDTO;
import com.example.project.models.PerformanceMetric;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PerformanceMetricMapper {
    @Mapping(source = "campaign.name", target = "campaignName")
    PerformanceMetricDTO toDTO(PerformanceMetric metric);

    @Mapping(target = "campaign.name", source = "campaignName")
    PerformanceMetric toEntity(PerformanceMetricDTO dto);

    List<PerformanceMetricDTO> toDTOs(List<PerformanceMetric> metrics);
}