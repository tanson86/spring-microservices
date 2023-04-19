package com.example.microservices.employeeservice.service;

import com.example.microservices.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    List<Employee> list = new ArrayList<>();

    public Employee save(Employee employee){
        list.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return list.stream().filter(p->p.id()==id).findFirst().orElseThrow();
    }

    public List<Employee> findAll(){
        return list;
    }

    public List<Employee> findByDepartment(Long id){
        return list.stream().filter(p->p.deptId()==id).collect(Collectors.toList());
    }
}
