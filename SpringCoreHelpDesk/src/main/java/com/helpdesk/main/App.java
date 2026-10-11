package com.helpdesk.main;

import com.helpdesk.Exceptions.InvalidCredentialsException;
import com.helpdesk.config.AppConfig;
import com.helpdesk.enums.Plan;
import com.helpdesk.enums.Role;
import com.helpdesk.model.Customer;
import com.helpdesk.model.Ticket;
import com.helpdesk.model.Users;
import com.helpdesk.service.CustomerService;
import com.helpdesk.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);
        UserService userService = context.getBean(UserService.class);

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("-----------------HELPDESK APP-----------------");
            System.out.println("1. Customer Signup");
            System.out.println("2. Customer Login");
            System.out.println("3. Executive Login");
            System.out.println("0. to Exit");
            System.out.println("-----------------------------------------------");

            int input = sc.nextInt();
            if(input == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (input){
                case 1 -> {
                    System.out.println("Customer sign up");
                    sc.nextLine();
                    Customer customer = new Customer();
                    Users user = new Users();

                    System.out.println("Enter your name: ");
                    customer.setName(sc.next());

                    System.out.println("Enter your age: ");
                    customer.setAge(sc.nextInt());

                    System.out.println("Select Plan: ");
                    Arrays.stream(Plan.values()).forEach(System.out::println);
                    customer.setPlan(Plan.valueOf(sc.next().toUpperCase()));

                    System.out.println("-- lets set up ur login credentials --");
                    System.out.println("Enter the username");
                    user.setUsername(sc.next());

                    System.out.println("Enter the password");
                    user.setPassword(sc.next());

                    user.setRole(Role.CUSTOMER);
                    user.setActive(true);

                    customer.setUsers(user);


                    try{
                        customerService.createCustomer(customer);
                        System.out.println("Signup Success");
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 2 -> {
                    System.out.println("Customer login");
                    System.out.println("Enter username: ");
                    String username = sc.next();
                    System.out.println("Enter password: ");
                    String password = sc.next();
                    try{
                        Users users = userService.login(username,password);
                        System.out.println("Login successful "+users);

                        if(users.getRole().equals(Role.CUSTOMER)){
                            System.out.println("Welcome customer "+users.getUsername());
                            System.out.println("Press 1 to see all tickets");
                            System.out.println("Press 0 to logout and go back to main menu");

                            if(sc.nextInt()==1){
                                System.out.println("------All Tickets-------");
                                List<Ticket> list  = customerService.getAllTickets(users.getUsername());
                                list.forEach(System.out::println);
                            }
                        }
                    }
                    catch(InvalidCredentialsException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                default -> {
                    System.out.println("Invalid option...");
                    return;
                }


            }
        }
        sc.close();
    }

}