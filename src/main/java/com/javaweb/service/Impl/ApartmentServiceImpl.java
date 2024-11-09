package com.javaweb.service.Impl;

import com.javaweb.dto.ApartmentDTO;
import com.javaweb.repository.ApartmentRepository;
import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.ContractEntity;
import com.javaweb.service.ApartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        ApartmentEntity entity = apartmentRepository.findById(id).orElse(null);
        return Optional.ofNullable(modelMapper.map(entity, ApartmentDTO.class));
    }

    @Override
    public ApartmentDTO save(ApartmentDTO apartmentDTO) {
        ApartmentEntity apartmentEntity = modelMapper.map(apartmentDTO, ApartmentEntity.class);
        apartmentEntity = apartmentRepository.save(apartmentEntity);
        return modelMapper.map(apartmentEntity, ApartmentDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        apartmentRepository.deleteById(id);
    }


    @Override
    public List<ApartmentDTO> findByBuildingId(Long buildingId) {
        // Implement this method based on your requirements
        return null;
    }

    @Override
    public ApartmentDTO getApartmentById(Long id) {
        ApartmentEntity entity = apartmentRepository.findById(id).orElse(null);
        return modelMapper.map(entity, ApartmentDTO.class);
    }

    @Override
    public void createApartment(ApartmentDTO apartmentDTO) {
        ApartmentEntity apartmentEntity = modelMapper.map(apartmentDTO, ApartmentEntity.class);
        apartmentRepository.save(apartmentEntity);
    }

    @Override
    public void updateApartment(ApartmentDTO apartmentDTO) {
        ApartmentEntity apartmentEntity = modelMapper.map(apartmentDTO, ApartmentEntity.class);
        apartmentRepository.saveAndFlush(apartmentEntity);
    }
}