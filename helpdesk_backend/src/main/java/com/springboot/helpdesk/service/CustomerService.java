package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.Request.CustomerDto;
import com.springboot.helpdesk.dto.Request.CustomerUpdateDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.CustomerMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.UserRepository;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public Customer getCustomerById(long id) {
        Optional<Customer> optional=customerRepository.findById(id);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Invalid id");
        return optional.get();
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomerById(long id) {
        getCustomerById(id);
        customerRepository.deleteById(id);
    }

    public void insertCustomer(@Valid CustomerDto customerDto) {
        //fetch user object from db
        User user = new User();
        user.setUsername(customerDto.username());
        user.setPassword(customerDto.password());
        user.setRole(Role.CUSTOMER);
        user = userRepository.save(user);

        // encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //prepare customer object
        Customer customer = CustomerMapper.convertDtoToModel(customerDto);

        //attach user to customer
        customer.setUser(user);

        //save to db
        customerRepository.save(customer);
    }

    public void update(Long id, CustomerUpdateDto dto) {
        Customer customer = getCustomerById(id);
        boolean flag = false;

        if(!(dto.name()==null) && !(dto.name().trim().isEmpty())){
            // If dto.name() is NOT(!) empty
            customer.setName((dto.name()));
            flag = true;
        }
    }
}
