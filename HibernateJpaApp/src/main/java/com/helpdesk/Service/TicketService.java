package com.helpdesk.Service;

import com.helpdesk.Enum.Priority;
import com.helpdesk.Enum.Status;
import com.helpdesk.Repository.CustomerRepository;
import com.helpdesk.Repository.TicketRepository;
import com.helpdesk.dto.TicketRespDto;
import com.helpdesk.exception.ResourceNotFoundException;
import com.helpdesk.mapper.TicketMapper;
import com.helpdesk.model.Customer;
import com.helpdesk.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    public TicketService(TicketRepository ticketRepository, CustomerRepository customerRepository) {
        this.ticketRepository = ticketRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void insertTicket(int customerId, String subject, String issue, Priority priority) {

        // Step 1: fetch Customer obj using given customerId
        Optional<Customer> optional = customerRepository.getCustomerById(customerId);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Invalid Customer Id......");

        Customer customer = optional.get();

        // Step 2: Prepare Ticket object
        Ticket ticket = new Ticket(subject,issue,priority, Status.OPEN);

        // Step 3: Attach customer obj to ticket obj

        ticket.setCustomer(customer);

        // Step 4: Add ticket object
        ticketRepository.insert(ticket);
    }

    public List<TicketRespDto> fetchTicketInfo() {
        //Step 1:fetch ticket object
        List<Ticket> list = ticketRepository.fetchAllTickets();
        //step 2:convert list<ticket> to list<TicketRespDto>

        return list.stream().map(TicketMapper ::mapDtoToModel).toList();
    }
}
