package com.example.springbootdemo.controller;

import com.example.springbootdemo.Repository.EmployeeRepository;
import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v2/employees")
@RestController
public class EmployeeV2Controller {

    @Autowired
    @Qualifier("employeeV2ServiceImpl")
    private EmployeeService employeeService;




    @PostMapping
    public Employee Save(@RequestBody Employee employee){
        return  employeeService.Save(employee) ;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id){ return employeeService.deleteEmployeeById(id);}
}
