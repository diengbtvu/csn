package com.javaweb.service.impl;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.ApartmentRepository;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.ContractEntity;
import com.javaweb.service.ApartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ApartmentDTO> findAll() {
        List<ApartmentEntity> entities = apartmentRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, ApartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ApartmentDTO> findById(Long id) {
        Optional<ApartmentEntity> entity = apartmentRepository.findById(id);
        return entity.map(apartmentEntity -> modelMapper.map(apartmentEntity, ApartmentDTO.class));
    }

    @Override
    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        ApartmentEntity apartmentEntity = modelMapper.map(apartmentDTO, ApartmentEntity.class);
        ApartmentEntity savedEntity = apartmentRepository.save(apartmentEntity);
        return modelMapper.map(savedEntity, ApartmentDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public List<ContractEntity> findContractsByApartmentId(Long apartmentId) {
        return apartmentRepository.findContractsByApartmentId(apartmentId);
    }


    @Override
    public List<ApartmentDTO> findByBuildingId(Long buildingId) {
        List<ApartmentEntity> entities = apartmentRepository.findByBuildingId(buildingId);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, ApartmentDTO.class))
                .collect(Collectors.toList());
    }
}