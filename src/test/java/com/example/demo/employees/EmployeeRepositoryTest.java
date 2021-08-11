package com.example.demo.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    Employee employee;

    @Autowired
    EmployeeRepository repository;

    @BeforeEach
    void init(){
        employee = new Employee("John Doe");
        employee.addAddresses(List.of(new Address("Bp1"), new Address("Bp2"), new Address("Bp3"), new Address("Bp4")));
        repository.save(employee);
    }

    @Test
    void test(){
        System.out.println(employee);
    }

}