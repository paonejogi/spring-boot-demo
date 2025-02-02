package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v2/employees")
@RestController
public class EmployeeV2Controller {

    @Autowired
    @Qualifier("employeeV2ServiceImpl")
    private EmployeeService employeeService;



    @PostMapping
    public Employee Save(@RequestBody Employee employee){

        return employee;
    }
}
