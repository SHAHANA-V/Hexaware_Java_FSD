package com.springboot.helpdesk.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ManagerDto(
        @NotBlank(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,

        @NotBlank(message = "Username is required")
        @NotNull(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        @NotNull(message = "Password is required")
        String password
) {
}
