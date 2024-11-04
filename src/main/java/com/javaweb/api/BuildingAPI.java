package com.javaweb.api;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<BuildingDTO> getAllBuildings() {
        List<BuildingDTO> buildingDTOS = buildingService.findAll();
        return buildingDTOS;
    }

    @GetMapping("/{id}")
    public BuildingDTO getBuildingById(@PathVariable Long id) {
        return buildingService.getBuildingById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.createBuilding(buildingDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBuilding(@PathVariable Long id, @RequestBody BuildingDTO buildingDTO) {
        buildingDTO.setId(id);
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        buildingService.saveAndFlush(buildingEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/apartments/{districtId}")
    public List<ApartmentDTO> getApartmentsByDistrictId(@PathVariable Long districtId) {
        return buildingService.findApartmentEntityByDistrictId(districtId);
    }
}