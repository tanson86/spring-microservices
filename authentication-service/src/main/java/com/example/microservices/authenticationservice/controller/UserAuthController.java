package com.example.microservices.authenticationservice.controller;

import com.example.microservices.authenticationservice.dto.AuthRequest;
import com.example.microservices.authenticationservice.entity.UserCredentials;
import com.example.microservices.authenticationservice.service.UserCredentialService;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserCredentialService userCredentialService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserCredentials uc){
        return userCredentialService.save(uc);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest ar) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(ar.getName(), ar.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userCredentialService.generateToken(ar.getName());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String getToken(@PathParam("token") String token){
        userCredentialService.validateToken(token);
        return "validated successfully";
    }
}
