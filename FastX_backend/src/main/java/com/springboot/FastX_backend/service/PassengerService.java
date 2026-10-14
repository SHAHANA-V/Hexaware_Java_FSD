package com.springboot.FastX_backend.service;

import com.springboot.FastX_backend.dto.request.PassengerDto;
import com.springboot.FastX_backend.dto.request.PassengerUpdateDto;
import com.springboot.FastX_backend.enums.Role;
import com.springboot.FastX_backend.exception.ResourceNotFoundException;
import com.springboot.FastX_backend.mapper.PassengerMapper;
import com.springboot.FastX_backend.model.Passenger;
import com.springboot.FastX_backend.model.User;
import com.springboot.FastX_backend.repository.PassengerRepository;
import com.springboot.FastX_backend.repository.UserRepository;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addPassenger(@Valid PassengerDto passengerDto) {

        //Step 1:Prepare the User object
        User user = new User();
        user.setUsername(passengerDto.username());
        user.setPassword(passwordEncoder.encode(passengerDto.password()));
        user.setRole(Role.PASSENGER);
        user = userRepository.save(user);

        //Step 2:Prepare Passenger Object
        Passenger passenger = PassengerMapper.convertDtoToModel(passengerDto);

        //Step 3:Attach the Passenger to User
        passenger.setUser(user);

        //step 4:Save the Passenger in db
        passengerRepository.save(passenger);

    }

    public Passenger getPassengerById(long passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(()->new ResourceNotFoundException("Passenger Id is invalid"));
    }

    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }

    public void deletePassengerById(long id) {
        getPassengerById(id);
        passengerRepository.deleteById(id);
    }

    public void updatePassenger(String passengerUsername, PassengerUpdateDto passengerUpdateDto) {
        Passenger passenger = passengerRepository.getPassengerByUsername(passengerUsername);
        boolean flag = false;

        //update name
        if(!(passengerUpdateDto.name()==null) && !(passengerUpdateDto.name().trim().isEmpty())){
            passenger.setName(passengerUpdateDto.name());
            flag = true;
        }

        //update phoneNo
        if(!(passengerUpdateDto.phoneNo()==null) && !(passengerUpdateDto.phoneNo().trim().isEmpty())){
            passenger.setPhoneNo(passengerUpdateDto.phoneNo());
            flag = true;
        }

        //update email
        if(!(passengerUpdateDto.email()==null) && !(passengerUpdateDto.email().trim().isEmpty())){
            passenger.setEmail(passengerUpdateDto.email());
            flag = true;
        }
        if (!flag) {
            throw new RuntimeException("No valid fields provided for update");
        }

        passengerRepository.save(passenger);
    }
}
