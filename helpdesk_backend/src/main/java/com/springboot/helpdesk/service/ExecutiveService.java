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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExecutiveService {
    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    public void add(@Valid ExecutiveDto executiveDto, Long managerId) {
        // Step 0: fetch manager from manager db
         Optional<Manager> optionalManager =  managerRepository.findById(managerId);
         if(optionalManager.isEmpty())
             throw new ResourceNotFoundException("Manager id is invalid");
         Manager manager = optionalManager.get();

        // Step 1: Prepare User object and save it in DB
        /*
        Executive
            User user <-- User must go in DB first and then Executive next
        * */
        User user = new User();
        user.setUsername(executiveDto.username());
        user.setPassword(executiveDto.password());
        user.setRole(Role.EXECUTIVE);
        user = userRepository.save(user); // <-- this is a full created user obj with id

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
