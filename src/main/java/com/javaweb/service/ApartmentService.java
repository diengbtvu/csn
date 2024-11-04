package com.javaweb.service;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.ContractEntity;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {
    List<ApartmentDTO> findAll();
    Optional<ApartmentDTO> findById(Long id);
    ApartmentDTO save(ApartmentDTO apartmentDTO);
    void deleteById(Long id);
    List<ContractEntity> findContractsByApartmentId(Long apartmentId);
    List<ApartmentDTO> findByBuildingId(Long buildingId);

}
