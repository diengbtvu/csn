package com.javaweb.service.Impl;
import com.javaweb.converter.UserAccountConverter;
import com.javaweb.dto.UserAccountDTO;
import com.javaweb.repository.UserAccountRepository;
import com.javaweb.repository.entity.UserAccountEntity;
import com.javaweb.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountConverter userAccountConverter;

    @Override
    public List<UserAccountDTO> findAll() {
        List<UserAccountEntity> entities = userAccountRepository.findAll();
        return entities.stream()
                .map(userAccountConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserAccountDTO> findById(Long id) {
        Optional<UserAccountEntity> entity = userAccountRepository.findById(id);
        return entity.map(userAccountConverter::convertToDTO);
    }

    @Override
    public void save(UserAccountDTO userAccountDTO) {
        UserAccountEntity entity = userAccountConverter.convertToEntity(userAccountDTO);
        userAccountRepository.save(entity);
    }

    @Override
    public void saveAndFlush(UserAccountDTO userAccountDTO) {
        UserAccountEntity entity = userAccountConverter.convertToEntity(userAccountDTO);
        userAccountRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(Long id) {
        userAccountRepository.deleteById(id);
    }

    @Override
    public UserAccountDTO findByUsername(String username) {
        UserAccountEntity entity = userAccountRepository.findByuserName(username);
        return userAccountConverter.convertToDTO(entity);
    }
}

