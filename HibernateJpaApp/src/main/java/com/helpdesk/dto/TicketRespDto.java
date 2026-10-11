package com.helpdesk.dto;

import com.helpdesk.Enum.JobTitle;
import com.helpdesk.Enum.Status;

import java.time.LocalDate;

public record TicketRespDto(
        int ticketId,
        String subject,
        LocalDate createdAt,
        Status status,
        String customerName,
        String customerUsername,
        Integer executiveId,
        JobTitle jobTitle
) {
}
