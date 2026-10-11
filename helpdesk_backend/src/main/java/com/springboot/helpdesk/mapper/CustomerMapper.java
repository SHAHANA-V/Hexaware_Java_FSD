package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.Request.CustomerDto;
import com.springboot.helpdesk.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static Customer convertDtoToModel(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.name());
        customer.setCity(customerDto.city());
        customer.setEmail(customerDto.email());
        return customer;
    }
}
