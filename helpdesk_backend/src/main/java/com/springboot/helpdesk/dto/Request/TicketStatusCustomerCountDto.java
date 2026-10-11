package com.springboot.helpdesk.dto.Request;

import com.springboot.helpdesk.enums.Status;

public record TicketStatusCustomerCountDto (
        Status status,
        long numberOfCustomers
){
}
