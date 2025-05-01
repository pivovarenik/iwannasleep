package com.example.project.mappers;

import com.example.project.DTO.AdRoiDTO;
import com.example.project.models.AdRoi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdRoiMapper {

    @Mapping(target = "campaignName", expression = "java(adRoi.getCampaign() != null ? adRoi.getCampaign().getName() : null)")
    AdRoiDTO toDTO(AdRoi adRoi);

    @Mapping(target = "campaign", ignore = true)
    AdRoi fromDTO(AdRoiDTO dto);

    List<AdRoiDTO> toDTOs(List<AdRoi> list);
}
