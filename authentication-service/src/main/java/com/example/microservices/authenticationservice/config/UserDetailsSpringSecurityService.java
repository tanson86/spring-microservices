package com.example.microservices.authenticationservice.config;

import com.example.microservices.authenticationservice.entity.UserCredentials;
import com.example.microservices.authenticationservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsSpringSecurityService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> ud = userCredentialRepository.findByName(username);
        return ud.map(UserDetailsSpringSecurity::new).orElseThrow(()->new UsernameNotFoundException("Invalid credential excpetion!!"));
    }
}
