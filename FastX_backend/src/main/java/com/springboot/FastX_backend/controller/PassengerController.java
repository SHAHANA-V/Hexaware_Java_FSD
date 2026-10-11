package com.springboot.FastX_backend.controller;

import com.springboot.FastX_backend.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;



}
