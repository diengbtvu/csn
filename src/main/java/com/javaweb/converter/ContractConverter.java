package com.javaweb.converter;

import com.javaweb.dto.ContractDTO;
import com.javaweb.repository.entity.ContractEntity;
import org.springframework.stereotype.Component;

@Component
public class ContractConverter {

    public ContractDTO convertToDTO(ContractEntity contractEntity) {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setId(contractEntity.getId());
        contractDTO.setApartmentId(contractEntity.getApartment().getId());
        contractDTO.setCustomerId(contractEntity.getCustomer().getId());
        contractDTO.setStartDate(contractEntity.getStartDate());
        contractDTO.setEndDate(contractEntity.getEndDate());
        contractDTO.setMonthlyRent(contractEntity.getMonthlyRent());
        contractDTO.setDeposit(contractEntity.getDeposit());
        contractDTO.setPaymentStatus(contractEntity.getPaymentStatus());
        return contractDTO;
    }

    public ContractEntity convertToEntity(ContractDTO contractDTO) {
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setId(contractDTO.getId());
        // Fetch and set ApartmentEntity and CustomerEntity based on IDs
        contractEntity.setStartDate(contractDTO.getStartDate());
        contractEntity.setEndDate(contractDTO.getEndDate());
        contractEntity.setMonthlyRent(contractDTO.getMonthlyRent());
        contractEntity.setDeposit(contractDTO.getDeposit());
        contractEntity.setPaymentStatus(contractDTO.getPaymentStatus());
        return contractEntity;
    }
}