package com.example.project.controllers;

import com.example.project.DTO.AdRoiDTO;
import com.example.project.services.AdRoiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roi")
@RequiredArgsConstructor
public class AdRoiController {

    private final AdRoiService service;

    @PostMapping
    public ResponseEntity<AdRoiDTO> create(@RequestBody AdRoiDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdRoiDTO> update(@PathVariable Long id, @RequestBody AdRoiDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdRoiDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdRoiDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
