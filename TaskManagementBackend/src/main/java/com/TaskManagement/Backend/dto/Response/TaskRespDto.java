package com.TaskManagement.Backend.dto.Response;

import com.TaskManagement.Backend.enums.Priority;
import com.TaskManagement.Backend.enums.Status;

import java.time.LocalDate;

public record TaskRespDto(
        String title,
        String description,
        LocalDate dueDate,
        Priority priority,
        Status Status,
        String customerName
) {
}
