package com.example.project.mappers;

import com.example.project.DTO.ReviewDTO;
import com.example.project.models.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO toDTO(Review review);
    Review toEntity(ReviewDTO dto);
    List<ReviewDTO> toDTOs(List<Review> reviews);
}
