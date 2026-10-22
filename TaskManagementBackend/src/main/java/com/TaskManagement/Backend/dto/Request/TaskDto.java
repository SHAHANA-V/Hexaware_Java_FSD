package com.TaskManagement.Backend.dto.Request;

import com.TaskManagement.Backend.enums.Priority;
import com.TaskManagement.Backend.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskDto(
        @NotBlank(message = "Title is required")
        @NotNull(message = "Title is required")
        String title,
        @NotBlank(message = "Description is required")
        @NotNull(message = "Description is required")
        String description,
        @NotNull(message = "Due Date is required")
        LocalDate dueDate,
        Priority priority,
        Status status
) {
}
