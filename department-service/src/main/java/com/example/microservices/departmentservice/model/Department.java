package com.example.microservices.departmentservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @NonNull
    Long id;
    String name;
    List<Employee> list = new ArrayList<>();
}
