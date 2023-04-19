package com.example.microservices.employeeservice.model;

public record Employee(Long id, Long deptId, String name, int age, String position) {
}
