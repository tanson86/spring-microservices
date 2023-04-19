package com.example.microservices.departmentservice.controller;

import com.example.microservices.departmentservice.client.EmployeeClient;
import com.example.microservices.departmentservice.model.Department;
import com.example.microservices.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeClient employeeClient;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){
        logger.info("Department add: {}", department);
        departmentService.addDepartment(department);
        return department;
    }

    @GetMapping("/getAll")
    public List<Department> getAll(){
        logger.info("get all");
        return departmentService.findAll();
    }

    @GetMapping("getById/{id}")
    public Department getById(@PathVariable Long id){
        logger.info("get by id: {}", id);
        return departmentService.findById(id);
    }

    @GetMapping("/getAllWithEmployees")
    public List<Department> getAllWithEmployees(){
        logger.info("get all with employees");
        return departmentService.findAll().stream().map(
                d->{
                    d.setList(employeeClient.findByDeptId(d.getId()));
                    return d;
                }
        ).collect(Collectors.toList());
    }
}
