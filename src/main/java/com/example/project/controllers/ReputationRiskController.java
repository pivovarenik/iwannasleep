package com.example.project.controllers;

import com.example.project.DTO.ReputationRiskDTO;
import com.example.project.services.ReputationRiskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reputation-risks")
@RequiredArgsConstructor
public class ReputationRiskController {
    private final ReputationRiskService service;

    @PostMapping
    public ResponseEntity<ReputationRiskDTO> create(@RequestBody ReputationRiskDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReputationRiskDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReputationRiskDTO> update(@PathVariable Long id, @RequestBody ReputationRiskDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
