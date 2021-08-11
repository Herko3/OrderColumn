package com.example.demo.employees;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository repository;
    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;

    public List<AddressDto> listAddresses() {
        return repository.findAll().stream()
                .map(a -> mapper.map(a, AddressDto.class))
                .toList();
    }

    @Transactional
    public AddressDto save(CreateAddressCommand command) {
        Employee employee = employeeRepository.getById(command.getEmployeeId());
        Address address = new Address(command.getCity());
        employee.addAddress(address);
        return mapper.map(address, AddressDto.class);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
