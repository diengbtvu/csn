package com.javaweb.repository;

import com.javaweb.repository.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    List<ContractEntity> findAll();
    Optional<ContractEntity> findById(Long id);
    ContractEntity save(ContractEntity entity);
    ContractEntity saveAndFlush(ContractEntity entity);
    void deleteById(Long id);

}