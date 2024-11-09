
// src/main/java/com/javaweb/service/ApartmentService.java
package com.javaweb.service;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.ContractEntity;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {
    List<ApartmentDTO> findAll();
    Optional<ApartmentDTO> findById(Long id);
    ApartmentDTO save(ApartmentDTO apartmentDTO);
    void deleteById(Long id);
    List<ApartmentDTO> findByBuildingId(Long buildingId);
    ApartmentDTO getApartmentById(Long id);
    void createApartment(ApartmentDTO apartmentDTO);
    public void updateApartment(ApartmentDTO apartmentDTO) ;// Add this method
}