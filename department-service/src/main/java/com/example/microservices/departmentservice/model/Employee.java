package com.example.microservices.departmentservice.model;

public record Employee(Long id,Long deptId,String name, int age, String position) {
}
