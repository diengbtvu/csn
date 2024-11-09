package com.javaweb.service.Impl;

import com.javaweb.converter.ContractConverter;
import com.javaweb.dto.ContractDTO;
import com.javaweb.repository.ContractRepository;
import com.javaweb.repository.entity.ContractEntity;
import com.javaweb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractConverter contractConverter;

    @Override
    public List<ContractDTO> findAll() {
        List<ContractEntity> entities = contractRepository.findAll();
        return entities.stream()
                .map(contractConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContractDTO> findById(Long id) {
        Optional<ContractEntity> entity = contractRepository.findById(id);
        return entity.map(contractConverter::convertToDTO);
    }

    @Override
    public void save(ContractDTO contractDTO) {
        ContractEntity contractEntity = contractConverter.convertToEntity(contractDTO);
        contractRepository.save(contractEntity);
    }

    @Override
    public void saveAndFlush(ContractDTO contractDTO) {
        ContractEntity contractEntity = contractConverter.convertToEntity(contractDTO);
        contractRepository.saveAndFlush(contractEntity);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}