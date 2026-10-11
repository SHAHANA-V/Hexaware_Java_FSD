package com.helpdesk.service;

import com.helpdesk.model.Customer;
import com.helpdesk.model.Ticket;
import com.helpdesk.repository.CustomerRepository;
import com.helpdesk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public CustomerService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer){
        // generate ids.
        int userId = (int)( Math.random()*100000);  //0.00 to 0.9999
        int customerId =  (int)( Math.random()*100000);

        // attaching to objects
        customer.getUsers().setId(userId);
        customer.setId(customerId);

        //user object goes to db
        userRepository.insertUser(customer.getUsers());

        //save customer to db
        customerRepository.insertCustomer(customer);
    }


    public List<Ticket> getAllTickets(String username) {
        return customerRepository.getAllTickets(username);
    }
}
