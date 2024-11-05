// src/main/java/com/javaweb/service/BuildingService.java
package com.javaweb.service;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.ApartmentDTO;
import com.javaweb.dto.BuildingAnalyticsDTO;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll();
    BuildingDTO getBuildingById(Long id);
    void createBuilding(BuildingDTO buildingDTO);
    void updateBuilding(BuildingDTO buildingDTO);
    void deleteById(Long id);
    List<ApartmentDTO> findApartmentEntityByDistrictId(Long districtId);
    List<ApartmentDTO> findByBuildingId(Long buildingId);
    List<BuildingAnalyticsDTO> getBuildingAnalytics();
}