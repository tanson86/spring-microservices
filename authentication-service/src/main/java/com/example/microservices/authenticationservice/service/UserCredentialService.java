package com.example.microservices.authenticationservice.service;

import com.example.microservices.authenticationservice.entity.UserCredentials;
import com.example.microservices.authenticationservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String save(UserCredentials uc){
        uc.setPassword(passwordEncoder.encode(uc.getPassword()));
        userCredentialRepository.save(uc);
        return "User saved successfully with id "+uc.getId();
    }

    public String generateToken(String userName){
        return jwtService.generateToken(userName);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
