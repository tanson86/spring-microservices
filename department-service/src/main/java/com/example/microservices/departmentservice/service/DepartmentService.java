package com.example.microservices.departmentservice.service;

import com.example.microservices.departmentservice.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    List<Department> list = new ArrayList<>();

    public Department addDepartment(Department department){
        list.add(department);
        return department;
    }

    public Department findById(Long id){
        return list.stream().filter(p->p.getId()==id).findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return list;
    }
}
