package com.example.demo.employees;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository repository;
    private ModelMapper mapper;

    public List<EmployeeDto> listEmployees() {
        return repository.findAll().stream()
                .map(e->mapper.map(e,EmployeeDto.class))
                .toList();
    }

    public EmployeeDto create(CreateEmployeeCommand command) {
        Employee employee = new Employee(command.getName());
        repository.save(employee);
        return mapper.map(employee,EmployeeDto.class);
    }
}
