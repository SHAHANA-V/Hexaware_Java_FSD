package com.springboot.helpdesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    // I will define a bean of type UserDetailsService
    // You are telling Spring: I don't want to use your details service,
    // I want to define my own Service and my own credentials.
    @Bean
    public UserDetailsService users() {
        UserDetails customer1 = User.builder()
                .username("customer1")
                .password("{noop}customer1")
                .roles("CUSTOMER")
                .build();
        UserDetails executive1 = User.builder()
                .username("executive1")
                .password("{noop}executive1")
                .roles("EXECUTIVE")
                .build();
        UserDetails manager1 = User.builder()
                .username("manager1")
                .password("{noop}manager1")
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(customer1, executive1,manager1);
    }
}
