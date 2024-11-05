// src/main/java/com/javaweb/service/impl/BuildingServiceImpl.java
package com.javaweb.service.Impl;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.ApartmentDTO;
import com.javaweb.dto.BuildingAnalyticsDTO;
import com.javaweb.repository.ApartmentRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingEntity> entities = buildingRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, BuildingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BuildingDTO getBuildingById(Long id) {
        BuildingEntity entity = buildingRepository.findById(id).orElse(null);
        return modelMapper.map(entity, BuildingDTO.class);
    }

    @Override
    public void createBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public void updateBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        buildingRepository.saveAndFlush(buildingEntity);
    }

    @Override
    public void deleteById(Long id) {
        buildingRepository.deleteById(id);
    }

    @Override
    public List<ApartmentDTO> findApartmentEntityByDistrictId(Long districtId) {
        List<BuildingEntity> buildingEntities = buildingRepository.findByDistrictId(districtId);
        return buildingEntities.stream()
                .map(entity -> modelMapper.map(entity, ApartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApartmentDTO> findByBuildingId(Long buildingId) {
        List<ApartmentEntity> entities = apartmentRepository.findByBuildingId(buildingId);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, ApartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BuildingAnalyticsDTO> getBuildingAnalytics() {
        return buildingRepository.findAll().stream()
                .map(building -> new BuildingAnalyticsDTO(
                        building.getName(),
                        building.getApartments().size()
                ))
                .collect(Collectors.toList());
    }
}