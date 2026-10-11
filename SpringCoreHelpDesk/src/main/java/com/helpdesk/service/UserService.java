package com.helpdesk.service;

import com.helpdesk.Exceptions.InvalidCredentialsException;
import com.helpdesk.model.Users;
import com.helpdesk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users login(String username, String password) {
        List<Users> list = userRepository.login(username,password);
        if(list==null ||list.isEmpty())
            throw new InvalidCredentialsException("Invalid Credentials...");
        return list.getFirst();
    }
}
