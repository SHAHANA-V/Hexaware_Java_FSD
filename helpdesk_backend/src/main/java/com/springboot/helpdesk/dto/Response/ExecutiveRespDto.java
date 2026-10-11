package com.springboot.helpdesk.dto.Response;

import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.Status;

import java.time.Instant;

public record ExecutiveRespDto(
        Long ticketId,
        Long executiveId,
        String executiveName,
        String ticketSubject,
        Priority ticketPriority,
        Status ticketStatus,
        Instant createdAt,
        Long customerId,
        String customerName
) {
}
