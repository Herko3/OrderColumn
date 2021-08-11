package com.example.demo.employees;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    private List<EmployeeDto> listEmployees(){
        return service.listEmployees();
    }

    @PostMapping
    private EmployeeDto create(@RequestBody CreateEmployeeCommand command){
        return service.create(command);
    }
}
