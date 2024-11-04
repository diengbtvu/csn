package com.javaweb.converter;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;

public class BuildingConverter {

    public static BuildingDTO toDTO(BuildingEntity entity) {
        if (entity == null) {
            return null;
        }
        BuildingDTO dto = new BuildingDTO();
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setNumberOfFloors(entity.getNumberOfFloors());
        dto.setTotalArea(entity.getTotalArea());
        dto.setType(entity.getType());
        dto.setContactNumber(entity.getContactNumber());
        dto.setDistrictId(entity.getDistrict().getId()); // Ensure districtId is set

        return dto;
    }
}