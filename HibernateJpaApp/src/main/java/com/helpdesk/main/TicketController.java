package com.helpdesk.main;

import com.helpdesk.Enum.Priority;
import com.helpdesk.Service.TicketService;
import com.helpdesk.config.AppConfig;
import com.helpdesk.dto.TicketRespDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TicketController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TicketService ticketService = context.getBean(TicketService.class);

        /*
        //prepare input
        String subject = "Internet shutdown";
        String issue = "My wifi router is not working, the lights are off too";
        Priority priority = Priority.RED;
        int customerId = 1;

        ticketService.insertTicket(customerId, subject, issue, priority);
        System.out.println("Ticket created........");

         */

        List<TicketRespDto> list = ticketService.fetchTicketInfo();
        list.forEach(System.out::println);
    }
}
