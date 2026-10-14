package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.Request.TicketDto;
import com.springboot.helpdesk.dto.Request.TicketStatusCustomerCountDto;
import com.springboot.helpdesk.dto.Response.TicketInfoDto;
import com.springboot.helpdesk.dto.Response.TicketRespDto;
import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/api/ticket/add")
    public void AddTicket(Principal principal, @Valid @RequestBody TicketDto ticketDto){
        ticketService.addTicket(principal.getName(),ticketDto);
    }

    // Done by Manager - activate the check after security config
    @PutMapping("/api/ticket/assign/{executiveId}/{ticketId}")
    public void AddExecutive(@PathVariable Long executiveId,@PathVariable Long ticketId,Principal principal){
        ticketService.assignExecutive(executiveId,ticketId,principal.getName());

    }

    @GetMapping("/api/ticket/v1/{customerId}")
    public List<TicketInfoDto> getTicketsByCustomerId(@PathVariable Long customerId,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("size") int size){
        return ticketService.getTicketsByCustomerId(customerId,page,size);

    }

    @GetMapping("/api/ticket/v2")//when u need pagination as optinal give these required = false and default value in string
    public List<TicketInfoDto> getTicketsByCustomerUsername(@RequestParam("username") String customerUsername,
                                                            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
                                                            @RequestParam(name = "size",required = false,defaultValue = "20") int size){
        return ticketService.getTicketsByCustomerUsername(customerUsername,page,size);
    }

    @GetMapping("/api/ticket/status/customer/stat/count")
    public List<TicketStatusCustomerCountDto> getTicketStatusCustomerCount(){
        return ticketService.getTicketStatusCustomerCount();
    }

    @GetMapping("/api/ticket/by-priority")
    public List<TicketRespDto> getTicketsByPriority(@RequestParam("priority")Priority priority){
        return ticketService.getTicketsByPriority(priority);
    }

    @GetMapping("/api/ticket/by-status")
    public List<TicketRespDto> getTicketsByStatus(@RequestParam("status")Status status){
        return ticketService.getTicketsByStatus(status);
    }

    @GetMapping("/api/ticket/byPriority-and-status")
    public List<TicketRespDto> getTicketsByPriorityAndStatus(@RequestParam("priority")Priority priority,
            @RequestParam("status")Status status){
        return ticketService.getTicketsByPriorityAndStatus(priority,status);
    }

    @GetMapping("/api/ticket/filter")
    public List<TicketRespDto> dynamicFilterTicket(@RequestParam(value = "priority",required = false) Priority priority,
                                                   @RequestParam(value = "status",required = false) Status status,
                                                   @RequestParam(value = "fromDate",required = false)LocalDate fromDate,
                                                   @RequestParam(value = "toDate",required = false)LocalDate toDate){
        return ticketService.dynamicFilterTicket(priority,status,fromDate,toDate);
    }

}
