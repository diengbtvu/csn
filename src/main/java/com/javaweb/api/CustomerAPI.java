package com.javaweb.api;

import com.javaweb.dto.CustomerDTO;
import com.javaweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {
    @Autowired
    private CustomerService contractService;

    @GetMapping
    public List<CustomerDTO> getAllContracts() {
        return contractService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getContractById(@PathVariable Long id) {
        Optional<CustomerDTO> contract = contractService.findById(id);
        return contract.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createContract(@RequestBody CustomerDTO contractDTO) {
        contractService.save(contractDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContract(@PathVariable Long id, @RequestBody CustomerDTO contractDTO) {
        contractDTO.setId(id);
        contractService.saveAndFlush(contractDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        contractService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}