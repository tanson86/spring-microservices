package com.example.microservices.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBack(){
        return "Error!!!!Department service is taking longer than expected..";
    }

    @GetMapping("/employeeServiceFallBack")
    public String employeeServiceFallBack(){
        return "Error!!!!Employee service is taking longer than expected..";
    }
}
