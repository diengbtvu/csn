package com.javaweb.api;

import com.javaweb.dto.UserAccountDTO;
import com.javaweb.security.JwtUtil;
import com.javaweb.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody UserAccountDTO user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
        );
        return jwtUtil.generateToken(user.getUserName());
    }

    @PostMapping("/register")
    public void register(@RequestBody UserAccountDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userAccountService.save(user);
    }
}