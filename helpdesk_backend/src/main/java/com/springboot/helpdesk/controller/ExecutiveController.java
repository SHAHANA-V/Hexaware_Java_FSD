package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.Request.ExecutiveDto;
import com.springboot.helpdesk.dto.Response.ExecutiveRespDto;
import com.springboot.helpdesk.service.ExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExecutiveController {

    private final ExecutiveService executiveService;

    @PostMapping("/api/executive/add/{managerId}")
    public void insertExecutive(@Valid @RequestBody ExecutiveDto executiveDto,
                                     @PathVariable Long managerId){

        executiveService.add(executiveDto,managerId);
    }

    @GetMapping("/api/executive/get")
    public List<ExecutiveRespDto> getTicketsByExecutiveName(@RequestParam("name") String executiveName,
                                                            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
                                                            @RequestParam(name = "size",required = false,defaultValue = "10") int size){
         return executiveService.getTicketsByExecutiveName(executiveName,page,size);
    }
}
