package com.TaskManagement.Backend.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerDto<username>(
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name is required")
        String name,
        @NotNull(message = "City is required")
        @NotBlank(message = "City is required")
        String city,
        @NotBlank(message = "Username is required")
        @NotNull(message = "Username is required")
        String username,
        @NotBlank(message = "Password is required")
        @NotNull(message = "Password is required")
        @Size(min = 5,max = 15,message = "Password should be between 5 to 15 characters")
        String password
) {
}
