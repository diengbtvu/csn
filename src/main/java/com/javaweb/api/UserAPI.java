package com.javaweb.api;
import com.javaweb.dto.UserAccountDTO;
import com.javaweb.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAPI {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public List<UserAccountDTO> getAllUsers() {
        return userAccountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDTO> getUserById(@PathVariable Long id) {
        Optional<UserAccountDTO> user = userAccountService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserAccountDTO userAccountDTO) {
        userAccountService.save(userAccountDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserAccountDTO userAccountDTO) {
        userAccountDTO.setId(id);
        userAccountService.saveAndFlush(userAccountDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAccountService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserAccountDTO> getUserByUsername(@PathVariable String username) {
        UserAccountDTO user = userAccountService.findByUsername(username);
        return ResponseEntity.ok(user);
    }
}