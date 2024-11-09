// src/main/java/com/javaweb/api/ApartmentAPI.java
package com.javaweb.api;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentAPI {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public List<ApartmentDTO> getAllApartments() {
        return apartmentService.findAll();
    }

    @GetMapping("/{id}")
    public ApartmentDTO getApartmentById(@PathVariable Long id) {
        return apartmentService.getApartmentById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createApartment(@RequestBody ApartmentDTO apartmentDTO) {
        apartmentService.createApartment(apartmentDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateApartment(@PathVariable Long id, @RequestBody ApartmentDTO apartmentDTO) {
        apartmentDTO.setId(id);
        apartmentService.updateApartment(apartmentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}