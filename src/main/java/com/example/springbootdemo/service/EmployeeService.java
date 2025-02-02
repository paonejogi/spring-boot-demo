package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Employee;

import java.util.List;


public interface EmployeeService {
    Employee Save(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);

}
