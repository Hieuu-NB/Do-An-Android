package com.example.springserver.controller;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.Employee;
import com.example.springserver.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/get-all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployee();
    }

    @PostMapping("/save")
    public ResultDto save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
