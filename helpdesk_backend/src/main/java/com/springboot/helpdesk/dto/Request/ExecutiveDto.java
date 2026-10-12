package com.springboot.helpdesk.dto.Request;

import com.springboot.helpdesk.enums.JobTitle;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExecutiveDto(
        @NotBlank(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,

        @NotBlank(message = "email is required")
        @NotNull(message = "email is required")
        @Email(message = "Email seems to be invalid")
        String email,

        @NotBlank(message = "Contact is required")
        @NotNull(message = "Contact is required")
        @Size(min = 10,max = 10,message = "contact should have 10 digit number")
        String contact,

        @NotBlank
        @NotNull
        String username,

        @NotNull
        @NotBlank
        String password,
        JobTitle jobTitle

) {
}
