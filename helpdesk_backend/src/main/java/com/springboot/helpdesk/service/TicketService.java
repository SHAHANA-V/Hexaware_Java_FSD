package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.Request.TicketDto;
import com.springboot.helpdesk.dto.Request.TicketStatusCustomerCountDto;
import com.springboot.helpdesk.dto.Response.TicketInfoDto;
import com.springboot.helpdesk.dto.Response.TicketRespDto;
import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.TicketMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Ticket;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import com.springboot.helpdesk.repository.TicketRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;
    private final ExecutiveRepository executiveRepository;

    public void addTicket(Long customerId, @Valid TicketDto ticketDto) {
        //fetch customer from customer db
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer Id Invalid"));

        //map ticketdto to ticket
        Ticket ticket = TicketMapper.convertDtoToEntity(ticketDto);

        //attach customer to ticket
        ticket.setCustomer(customer);
        ticket.setStatus(Status.OPEN);

        //save ticket in db
        ticketRepository.save(ticket);
    }

    public void assignExecutive(Long executiveId, Long ticketId) {
        //fetch executive from db
        Executive executive = executiveRepository.findById(executiveId)
                .orElseThrow(()-> new ResourceNotFoundException("Executive Id Invalid"));
        //fetch ticket from db

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(()-> new ResourceNotFoundException("Ticket Id is invalid"));
        //attach executive to ticket

        ticket.setExecutive(executive);

        //save ticket
        ticketRepository.save(ticket);
    }

    public List<TicketInfoDto> getTicketsByCustomerId(Long customerId, int page, int size) {
        // Create an Instance of Pageable interface using page and size values thru PageRequest
        Pageable pageable = PageRequest.of(page,size);
        return ticketRepository.getTicketsByCustomerId(customerId,pageable);
    }

    public List<TicketInfoDto> getTicketsByCustomerUsername(String customerUsername, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return ticketRepository.getTicketsByCustomerUsername(customerUsername,pageable);
    }

    public List<TicketStatusCustomerCountDto> getTicketStatusCustomerCount() {
        return ticketRepository.getTicketStatusCustomerCount();
    }

    public List<TicketRespDto> getTicketsByPriority(Priority priority) {
        List<Ticket> list= ticketRepository.findByPriority(priority);
        // Map List<Ticket> to List<TicketDto> using Mapper

        return list.stream().map(TicketMapper::convertEntityToModel).toList();
    }

    public List<TicketRespDto> getTicketsByStatus(Status status) {
        List<Ticket> list = ticketRepository.findByStatus(status);

        return list.stream().map(TicketMapper::convertEntityToModel).toList();
    }

    public List<TicketRespDto> getTicketsByPriorityAndStatus(Priority priority, Status status) {
        List<Ticket> list = ticketRepository.findByPriorityAndStatus(priority,status);
        return list.stream().map(TicketMapper::convertEntityToModel).toList();
    }

    public List<TicketRespDto> dynamicFilterTicket(Priority priority, Status status, LocalDate fromDate, LocalDate toDate) {

        return ticketRepository.dynamicFilterTicket(priority,status,
                fromDate == null?null:fromDate.atStartOfDay(ZoneOffset.UTC).toInstant(),
                toDate  == null?null:toDate.atStartOfDay(ZoneOffset.UTC).toInstant());
    }
}
