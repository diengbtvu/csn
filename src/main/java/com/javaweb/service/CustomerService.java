package com.javaweb.service;

import com.javaweb.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> findAll();
    Optional<CustomerDTO> findById(Long id);
    void  save(CustomerDTO entity);
    void  saveAndFlush(CustomerDTO entity);
    void deleteById(Long id);
}
