package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.Request.AdminDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserObj(String username, String password, Role role){
        User user =  new User(username,password,role);
        return userRepository.save(user);
    }

    public void addAdmin(AdminDto adminDto) {
        //prepare user using adminDto

        User user = new User(
                adminDto.username(),
                passwordEncoder.encode(adminDto.password()),
                Role.ADMIN
        );

        //save in user db
        userRepository.save(user);
    }
}
