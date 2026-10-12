package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.Request.ExecutiveDto;
import com.springboot.helpdesk.dto.Response.ExecutiveRespDto;
import com.springboot.helpdesk.service.ExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExecutiveController {

    private final ExecutiveService executiveService;

    @PostMapping("/api/executive/add")
    public void insertExecutive(@Valid @RequestBody ExecutiveDto executiveDto,
                                Principal principal){

        executiveService.add(executiveDto,principal.getName());// principal.getName() give us logged manager username
    }

    @GetMapping("/api/executive/get")
    public List<ExecutiveRespDto> getTicketsByExecutiveName(@RequestParam("name") String executiveName,
                                                            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
                                                            @RequestParam(name = "size",required = false,defaultValue = "10") int size){
         return executiveService.getTicketsByExecutiveName(executiveName,page,size);
    }
}
