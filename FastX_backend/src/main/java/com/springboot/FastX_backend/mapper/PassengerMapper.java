package com.springboot.FastX_backend.mapper;

import com.springboot.FastX_backend.dto.request.PassengerDto;
import com.springboot.FastX_backend.model.Passenger;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {
    public static Passenger convertDtoToModel(PassengerDto passengerDto){
       Passenger passenger = new Passenger();
       passenger.setName(passengerDto.name());
       passenger.setPhoneNo(passengerDto.phoneNo());
       passenger.setEmail(passengerDto.email());
       return passenger;
    }

}
