package com.TaskManagement.Backend.service;

import com.TaskManagement.Backend.dto.Request.CustomerDto;
import com.TaskManagement.Backend.enums.Role;
import com.TaskManagement.Backend.mapper.CustomerMapper;
import com.TaskManagement.Backend.model.Customer;
import com.TaskManagement.Backend.model.User;
import com.TaskManagement.Backend.repository.CustomerRepository;
import com.TaskManagement.Backend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    public void insertCustomer(@Valid CustomerDto customerDto) {
        //fetch user object from db
        User user = new User();
        user.setUsername(customerDto.username());
        user.setPassword(passwordEncoder.encode(customerDto.password()));
        user.setRole(Role.CUSTOMER);
        user = userRepository.save(user);

        Customer customer = CustomerMapper.convertDtoToModel(customerDto);

        //attach user to customer
        customer.setUser(user);

        //save to db
        customerRepository.save(customer);
    }
}
