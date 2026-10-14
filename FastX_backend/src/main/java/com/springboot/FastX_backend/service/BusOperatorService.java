package com.springboot.FastX_backend.service;

import com.springboot.FastX_backend.dto.request.BusOperatorDto;
import com.springboot.FastX_backend.enums.Role;
import com.springboot.FastX_backend.exception.ResourceNotFoundException;
import com.springboot.FastX_backend.mapper.BusOperatorMapper;
import com.springboot.FastX_backend.model.Bus;
import com.springboot.FastX_backend.model.BusOperator;
import com.springboot.FastX_backend.model.User;
import com.springboot.FastX_backend.repository.BusOperatorRepository;
import com.springboot.FastX_backend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusOperatorService {
    private final BusOperatorRepository busOperatorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addBusOperator(@Valid BusOperatorDto busOperatorDto) {

        //STEP 1:prepare user objects
        User user = new User();
        user.setUsername(busOperatorDto.username());
        user.setPassword(passwordEncoder.encode(busOperatorDto.password()));
        user.setRole(Role.BUS_OPERATOR);
        user = userRepository.save(user);

        //STEP 2:prepare bus operator object
        BusOperator busOperator = BusOperatorMapper.convertDtoToEntity(busOperatorDto);

        //STEP 3:Attach the user to bus operator
        busOperator.setUser(user);

        //STEP 4:save the bus operator in db
        busOperatorRepository.save(busOperator);

    }

    public List<BusOperator> getAllBusOperator() {
        return busOperatorRepository.findAll();
    }

    public BusOperator getBusOperatorByUsername(String busOperatorName) {
        return busOperatorRepository.getBusOperatorByUsername(busOperatorName)
                .orElseThrow(()->new ResourceNotFoundException("No records found on this username"));
    }
}
