package com.helpdesk.Service;

import com.helpdesk.Repository.CustomerRepository;
import com.helpdesk.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void insert(String name, String city) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCity(city);
        customerRepository.insert(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }



}
