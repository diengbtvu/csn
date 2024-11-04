package com.javaweb.service;

import java.util.List;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.web.bind.annotation.PathVariable;
import com.javaweb.dto.ApartmentDTO;
public interface BuildingService {
    public List<BuildingDTO> findAll();
    public BuildingDTO getBuildingById(@PathVariable Long id);
    public void createBuilding(BuildingDTO buildingDTO);
    public <S extends BuildingEntity> S saveAndFlush(S entity);
    public void deleteById(Long id);
    public List<ApartmentDTO> findApartmentEntityByDistrictId(Long districtId);
    List<ApartmentDTO> findByBuildingId(Long buildingId);
}
