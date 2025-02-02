package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Override
    public Employee Save(Employee employee) {
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public String deleteEmployeeById(String id) {
        return "";
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }
}
