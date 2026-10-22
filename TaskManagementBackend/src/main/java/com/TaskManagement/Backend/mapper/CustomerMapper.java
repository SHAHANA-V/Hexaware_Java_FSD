package com.TaskManagement.Backend.mapper;

import com.TaskManagement.Backend.dto.Request.CustomerDto;
import com.TaskManagement.Backend.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public  static Customer convertDtoToModel(CustomerDto customerDto){
        Customer customer= new Customer();
        customer.setName(customerDto.name());
        customer.setCity(customerDto.city());
        return customer;
    }
}
