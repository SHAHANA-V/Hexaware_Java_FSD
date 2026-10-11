package com.helpdesk.main;

import com.helpdesk.Service.CustomerService;
import com.helpdesk.config.AppConfig;
import com.helpdesk.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);
//        customerService.insert("Harry Potter","London");
//        System.out.println("Customer inserted successfully....");

        List<Customer> list = customerService.getAllCustomer();
        list.forEach(System.out::println);

    }
}
