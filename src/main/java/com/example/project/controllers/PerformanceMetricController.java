package com.example.project.controllers;

import com.example.project.DTO.PerformanceMetricDTO;
import com.example.project.services.PerformanceMetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performance-metrics")
@RequiredArgsConstructor
public class PerformanceMetricController {
    private final PerformanceMetricService service;

    @PostMapping
    public ResponseEntity<PerformanceMetricDTO> create(@RequestBody PerformanceMetricDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<PerformanceMetricDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerformanceMetricDTO> update(@PathVariable Long id, @RequestBody PerformanceMetricDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
