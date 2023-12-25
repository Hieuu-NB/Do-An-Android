package com.example.springserver.service;

import com.example.springserver.dto.response.ResultDto;
import com.example.springserver.entity.Employee;
import com.example.springserver.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repository;
    @Override
    public ResultDto saveEmployee(Employee employee) {
        try {
            repository.save(employee);
        }catch (Exception e){
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("thanh cong").build();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }
}
