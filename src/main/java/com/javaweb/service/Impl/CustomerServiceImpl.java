package com.javaweb.service.Impl;

import com.javaweb.dto.CustomerDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.entity.CustomerEntity;
import com.javaweb.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerEntity> entities = customerRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> findById(Long id) {
        Optional<CustomerEntity> entity = customerRepository.findById(id);
        return entity.map(customerEntity -> modelMapper.map(customerEntity, CustomerDTO.class));
    }

    @Override
    public void save(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public void saveAndFlush(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        customerRepository.saveAndFlush(customerEntity);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
