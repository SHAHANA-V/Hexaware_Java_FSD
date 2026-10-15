package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.Request.ExecutiveDto;
import com.springboot.helpdesk.dto.Response.ExecutiveRespDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.ExecutiveMapper;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Manager;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import com.springboot.helpdesk.repository.ManagerRepository;
import com.springboot.helpdesk.repository.UserRepository;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExecutiveService {
    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public void add(@Valid ExecutiveDto executiveDto, String managerUsername) {
        // Step 0: fetch manager from manager db
         Manager manager =  managerRepository.getByUsername(managerUsername);


        // Step 1: Prepare User object and save it in DB
        /*
        Executive
            User user <-- User must go in DB first and then Executive next
        * */
        User user = userService.getUserObj(  // <-- this is a full created user obj with id
                executiveDto.username(),
                executiveDto.password(),
                Role.EXECUTIVE
        );

        // Step 1.5 Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Step 2: Map ExecutiveDto to Executive entity
        Executive executive = ExecutiveMapper.mapDtoToModel(executiveDto);

        //Step 3 : attach user to executive

        executive.setUser(user);
        executive.setManager(manager);

        //Step 4:save executive to db

        executiveRepository.save(executive);
    }

    public List<ExecutiveRespDto> getTicketsByExecutiveName(String executiveName, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return executiveRepository.getTicketsByExecutiveName(executiveName,pageable);
    }
}
