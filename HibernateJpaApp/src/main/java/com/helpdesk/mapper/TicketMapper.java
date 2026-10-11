package com.helpdesk.mapper;

import com.helpdesk.dto.TicketRespDto;
import com.helpdesk.model.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Component
public class TicketMapper {
    public static TicketRespDto mapDtoToModel(Ticket ticket){
        return new TicketRespDto(
                ticket.getId(),
                ticket.getSubject(),
                LocalDate.ofInstant(ticket.getCreatedAt(), ZoneOffset.UTC),
                ticket.getStatus(),
                ticket.getCustomer().getName(),
                ticket.getCustomer().getUser()==null? null:ticket.getCustomer().getUser().getName(),
                ticket.getExecutive()==null ? null: ticket.getExecutive().getId(),
                ticket.getExecutive()==null? null : ticket.getExecutive().getJobTitle()

        );

    }
}
