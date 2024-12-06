// src/main/java/com/javaweb/api/BuildingAPI.java
package com.javaweb.api;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.ApartmentDTO;
import com.javaweb.dto.BuildingAnalyticsDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<BuildingDTO> getAllBuildings() {
        return buildingService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public BuildingDTO getBuildingById(@PathVariable Long id) {
        return buildingService.getBuildingById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.createBuilding(buildingDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> updateBuilding(@PathVariable Long id, @RequestBody BuildingDTO buildingDTO) {
        buildingDTO.setId(id);
        buildingService.updateBuilding(buildingDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/apartments/{districtId}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ApartmentDTO> getApartmentsByDistrictId(@PathVariable Long districtId) {
        return buildingService.findApartmentEntityByDistrictId(districtId);
    }

    @GetMapping("/analytics")
    @PreAuthorize("hasRole('ADMIN')")
    public List<BuildingAnalyticsDTO> getBuildingAnalytics() {
        return buildingService.getBuildingAnalytics();
    }
}