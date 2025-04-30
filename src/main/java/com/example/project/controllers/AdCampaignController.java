package com.example.project.controllers;

import com.example.project.DTO.AdCampaignDTO;
import com.example.project.DTO.TimesDTO;
import com.example.project.services.AdCampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class AdCampaignController {
    private final AdCampaignService service;

    public AdCampaignController(AdCampaignService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AdCampaignDTO> create(@RequestBody AdCampaignDTO dto) {
        return ResponseEntity.ok(service.createCampaign(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdCampaignDTO> update(@PathVariable Long id, @RequestBody AdCampaignDTO dto) {
        return ResponseEntity.ok(service.updateCampaign(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdCampaignDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCampaigns());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdCampaignDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCampaignById(id));
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<AdCampaignDTO> changeStatus(@PathVariable Long id, @RequestParam(required = false, defaultValue = "stopped") String status) {
        return ResponseEntity.ok(service.changeStatus(id, status));
    }
    @GetMapping("/{id}/time")
    public ResponseEntity<TimesDTO> getTime(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCampaignTime(id));
    }
    @GetMapping("/{id}/target")
    public ResponseEntity<String> getTarget(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTargetAudience(id));
    }
}
