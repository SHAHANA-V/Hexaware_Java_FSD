package com.springboot.FastX_backend.controller;

import com.springboot.FastX_backend.dto.request.BusOperatorDto;
import com.springboot.FastX_backend.model.BusOperator;
import com.springboot.FastX_backend.service.BusOperatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BusOperatorController {
    private final BusOperatorService busOperatorService;

    @PostMapping("/api/busoperator/add")
    public void addBusOperator(@Valid @RequestBody BusOperatorDto busOperatorDto){
        busOperatorService.addBusOperator(busOperatorDto);
    }

    @GetMapping("/api/busOperator/all")
    public List<BusOperator> getAllBusOperator(){
        return busOperatorService.getAllBusOperator();
    }

    @GetMapping("/api/busOperator/byUsername")
    public BusOperator getBusOperatorByUsername(@RequestParam("name") String busOperatorName){
        return busOperatorService.getBusOperatorByUsername(busOperatorName);
    }
}
