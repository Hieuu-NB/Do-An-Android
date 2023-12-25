package com.example.springserver.service;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.Employee;

import java.util.List;

public interface EmployeeService {
    ResultDto saveEmployee(Employee employee);
    List<Employee> findAllEmployee();
}
