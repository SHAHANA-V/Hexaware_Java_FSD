package com.springboot.FastX_backend.service;

import com.springboot.FastX_backend.dto.request.PassengerDto;
import com.springboot.FastX_backend.enums.Role;
import com.springboot.FastX_backend.mapper.PassengerMapper;
import com.springboot.FastX_backend.model.Passenger;
import com.springboot.FastX_backend.model.User;
import com.springboot.FastX_backend.repository.PassengerRepository;
import com.springboot.FastX_backend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;

    public void addPassenger(@Valid PassengerDto passengerDto) {

        //Step 1:Prepare the User object
        User user = new User();
        user.setUsername(passengerDto.username());
        user.setPassword(passengerDto.password());
        user.setRole(Role.PASSENGER);
        user = userRepository.save(user);

        //Step 2:Prepare Passenger Object
        Passenger passenger = PassengerMapper.convertDtoToModel(passengerDto);

        //Step 3:Attach the Passenger to User
        passenger.setUser(user);

        //step 4:Save the Passenger in db
        passengerRepository.save(passenger);



    }
}
