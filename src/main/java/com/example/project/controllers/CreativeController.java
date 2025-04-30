package com.example.project.controllers;

import com.example.project.DTO.CreativeDTO;
import com.example.project.services.CreativeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creatives")
public class CreativeController {
    private final CreativeService service;
    public CreativeController(CreativeService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CreativeDTO> create(@RequestBody CreativeDTO dto) {
        return ResponseEntity.ok(service.createCreative(dto));
    }

    @GetMapping
    public List<CreativeDTO> all() {
        return service.getAllCreatives();
    }

    @GetMapping("/campaign/{campaignId}")
    public List<CreativeDTO> byCampaign(@PathVariable Long campaignId) {
        return service.getByCampaign(campaignId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreativeDTO> update(@PathVariable Long id, @RequestBody CreativeDTO dto) {
        return ResponseEntity.ok(service.updateCreative(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCreative(id);
        return ResponseEntity.noContent().build();
    }
}
