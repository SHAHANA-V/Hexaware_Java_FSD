package com.TaskManagement.Backend.controller;

import com.TaskManagement.Backend.dto.Request.CustomerDto;
import com.TaskManagement.Backend.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/api/customer/add")
    public void insertCustomer(@Valid @RequestBody CustomerDto customerDto){

        customerService.insertCustomer(customerDto);
    }
}
