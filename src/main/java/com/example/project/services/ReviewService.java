package com.example.project.services;

import com.example.project.DTO.ReviewDTO;
import com.example.project.mappers.ReviewMapper;
import com.example.project.models.Review;
import com.example.project.repos.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    public ReviewDTO create(ReviewDTO dto) {
        Review entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public List<ReviewDTO> getAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public ReviewDTO update(Long id, ReviewDTO dto) {
        Review review = repository.findById(id).orElseThrow();
        review.setSource(dto.source());
        review.setContentText(dto.contentText());
        review.setSentiment(dto.sentiment());
        return mapper.toDTO(repository.save(review));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
