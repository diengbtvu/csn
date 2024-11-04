package com.javaweb.api;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.ContractEntity;
import com.javaweb.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartments")
public class ApartmentAPI {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public List<ApartmentDTO> getAllApartments() {

        return apartmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentDTO> getApartmentById(@PathVariable Long id) {
        Optional<ApartmentDTO> apartmentDTO = apartmentService.findById(id);
        return apartmentDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApartmentDTO> createApartment(@RequestBody ApartmentDTO apartmentDTO) {
        ApartmentDTO createdApartment = apartmentService.save(apartmentDTO);
        return ResponseEntity.ok(createdApartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApartmentDTO> updateApartment(@PathVariable Long id, @RequestBody ApartmentDTO apartmentDTO) {
        apartmentDTO.setId(id);
        ApartmentDTO updatedApartment = apartmentService.save(apartmentDTO);
        return ResponseEntity.ok(updatedApartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/contracts")
    public List<ContractEntity> getContractsByApartmentId(@PathVariable Long id) {
        return apartmentService.findContractsByApartmentId(id);
    }

    @GetMapping("/building/{buildingId}")
    public List<ApartmentDTO> getApartmentsByBuildingId(@PathVariable Long buildingId) {
        return apartmentService.findByBuildingId(buildingId);
    }

}