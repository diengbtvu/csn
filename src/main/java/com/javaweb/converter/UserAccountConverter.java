package com.javaweb.converter;

import com.javaweb.dto.UserAccountDTO;
import com.javaweb.repository.entity.UserAccountEntity;
import org.springframework.stereotype.Component;

@Component
public class UserAccountConverter {

    public UserAccountDTO convertToDTO(UserAccountEntity entity) {
        UserAccountDTO dto = new UserAccountDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        return dto;
    }

    public UserAccountEntity convertToEntity(UserAccountDTO dto) {
        UserAccountEntity entity = new UserAccountEntity();
        entity.setId(dto.getId());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        return entity;
    }
}