package com.springboot.FastX_backend.controller;

import com.springboot.FastX_backend.dto.request.PassengerDto;
import com.springboot.FastX_backend.dto.request.PassengerUpdateDto;
import com.springboot.FastX_backend.model.Passenger;
import com.springboot.FastX_backend.service.PassengerService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController

public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping("/api/passenger/add")
    public void addPassenger(@Valid @RequestBody PassengerDto passengerDto){
        passengerService.addPassenger(passengerDto);
    }

    @GetMapping("/api/passenger/{passengerId}")
    public Passenger getPassengerById(@PathVariable long passengerId){
        return passengerService.getPassengerById(passengerId);
    }

    @GetMapping("/api/passenger/all")
    public List<Passenger> getAllPassenger(){
        return passengerService.getAllPassenger();
    }

    @DeleteMapping("/api/passenger/delete/{id}")
    public void deletePassengerById(@PathVariable long id){
        passengerService.deletePassengerById(id);
    }

    @PutMapping("/api/passenger/update")
    public void updatePassenger(Principal principal,@Valid @RequestBody PassengerUpdateDto passengerUpdateDto){
        passengerService.updatePassenger(principal.getName(),passengerUpdateDto);
    }

}
