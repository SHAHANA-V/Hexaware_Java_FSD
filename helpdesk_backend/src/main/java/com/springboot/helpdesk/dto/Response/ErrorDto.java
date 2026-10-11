package com.springboot.helpdesk.dto.Response;

import java.time.Instant;

public record ErrorDto(
        String message,
        String comment,
        Instant timeStamp
) {
}
