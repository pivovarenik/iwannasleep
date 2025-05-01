package com.example.project.controllers;

import com.example.project.DTO.AudienceDTO;
import com.example.project.DTO.BusinessAnalyticDTO;
import com.example.project.services.AudienceService;
import com.example.project.services.BusinessAnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audience")
public class AudienceController {
    private final AudienceService service;

    @PostMapping
    public ResponseEntity<AudienceDTO> create(@RequestBody AudienceDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AudienceDTO>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AudienceDTO> update(@PathVariable Long id, @RequestBody AudienceDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

