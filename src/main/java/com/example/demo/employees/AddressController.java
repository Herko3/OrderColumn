package com.example.demo.employees;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping
    public List<AddressDto> listAddresses() {
        return service.listAddresses();
    }

    @PostMapping
    public AddressDto save(@RequestBody CreateAddressCommand command) {
        return service.save(command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") long id){
        service.delete(id);
    }
}
