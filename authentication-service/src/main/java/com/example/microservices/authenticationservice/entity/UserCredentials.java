package com.example.microservices.authenticationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
}
