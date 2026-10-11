package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.Request.CustomerDto;
import com.springboot.helpdesk.dto.Request.CustomerUpdateDto;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/api/customer/add")
    public void insertCustomer(@Valid @RequestBody CustomerDto customerDto){

        customerService.insertCustomer(customerDto);
    }

    @GetMapping("/api/customer/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/api/customer/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/api/customer/{id}")
    public void deleteCustomerById(@PathVariable long id){
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/api/customer/{id}")
    public void update(@PathVariable Long id,@RequestBody CustomerUpdateDto dto){
        customerService.update(id,dto);
    }
}
