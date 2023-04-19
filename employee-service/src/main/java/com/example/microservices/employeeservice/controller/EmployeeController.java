package com.example.microservices.employeeservice.controller;

import com.example.microservices.employeeservice.model.Employee;
import com.example.microservices.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        employeeService.save(employee);
        logger.info("Saving employee: {}", employee);
        return employee;
    }

    @GetMapping("/findEmp/{id}")
    public Employee findById(@PathVariable Long id){
        logger.info("Find employee: {}", id);
        return employeeService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Employee> findByAll(){
        logger.info("Finding all employee");
        return employeeService.findAll();
    }

    @GetMapping("/findEmpByDeptId/{id}")
    public List<Employee> findByDeptId(@PathVariable Long id){
        logger.info("findEmpById: {}", id);
        return employeeService.findByDepartment(id);
    }
}
