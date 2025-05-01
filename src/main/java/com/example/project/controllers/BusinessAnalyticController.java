package com.example.project.controllers;

import com.example.project.DTO.BusinessAnalyticDTO;
import com.example.project.services.BusinessAnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/business-analytics")
public class BusinessAnalyticController {
    private final BusinessAnalyticService service;

    @PostMapping
    public ResponseEntity<BusinessAnalyticDTO> create(@RequestBody BusinessAnalyticDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<BusinessAnalyticDTO>> all() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessAnalyticDTO> update(@PathVariable Long id, @RequestBody BusinessAnalyticDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
