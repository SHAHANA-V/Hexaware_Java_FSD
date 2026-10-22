package com.TaskManagement.Backend.dto.Request;

import com.TaskManagement.Backend.enums.Priority;
import com.TaskManagement.Backend.enums.Status;

import java.time.LocalDate;

public record TaskUpdateDto(
        String title,
        String description,
        LocalDate dueDate,
        Priority priority,
        Status status
) {
}
