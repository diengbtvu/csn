package com.javaweb.repository;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    // Method to get all buildings
    List<BuildingEntity> findAll();

    // Method to get building details by ID
    Optional<BuildingEntity> findById(Long id);

    List<BuildingEntity> findByDistrictId(Long districtId);

    // Method to create a new building
    <S extends BuildingEntity> S save(S entity);

    // Method to update building details by ID
    <S extends BuildingEntity> S saveAndFlush(S entity);

    // Method to delete a building by ID
    void deleteById(Long id);

    // Method to get all apartments by building ID
    List<ApartmentDTO> findApartmentEntityByDistrictId(Long districtId);


}
