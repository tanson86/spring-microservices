package com.example.microservices.authenticationservice.repository;

import com.example.microservices.authenticationservice.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredentials,Integer> {
    Optional<UserCredentials> findByName(String username);
}
