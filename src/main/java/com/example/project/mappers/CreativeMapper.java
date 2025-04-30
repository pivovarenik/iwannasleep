package com.example.project.mappers;

import com.example.project.DTO.CreativeDTO;
import com.example.project.models.AdCampaign;
import com.example.project.models.Creative;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreativeMapper {
    @Mapping(target = "campaignName", expression = "java(creative.getCampaign() != null ? creative.getCampaign().getName() : null)")
    CreativeDTO creativeToDTO(Creative creative);
    @Mapping(target = "campaign", expression = "java(findCampaignByName(dto.campaignName()))")
    Creative dtoToCreative(CreativeDTO dto);
    List<CreativeDTO> creativesToDTOs(List<Creative> creatives);
    default AdCampaign findCampaignByName(String campaignName) {
        return null;
    }
}
