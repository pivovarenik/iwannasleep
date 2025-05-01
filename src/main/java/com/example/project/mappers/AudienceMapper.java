
// Mappers
package com.example.project.mappers;

import com.example.project.DTO.AudienceDTO;
import com.example.project.DTO.BusinessAnalyticDTO;
import com.example.project.models.Audience;
import com.example.project.models.BusinessAnalytic;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AudienceMapper {
    @Mapping(source = "campaign.name", target = "campaignName")
    AudienceDTO toDto(Audience audience);

    @Mapping(target = "campaign", ignore = true)
    Audience toEntity(AudienceDTO dto);

    List<AudienceDTO> toDtoList(List<Audience> list);
}