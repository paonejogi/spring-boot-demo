package com.example.springbootdemo.service;

import com.example.springbootdemo.Repository.EmployeeRepository;
import com.example.springbootdemo.entity.EmployeeEntity;
import com.example.springbootdemo.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Override
    public Employee Save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);
        return employee;
    }
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList
                = employeeRepository.findAll();

        List<Employee> employees
                = employeeEntityList
                .stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                })
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee with id " + id + "Is Deleted";
    }
}
