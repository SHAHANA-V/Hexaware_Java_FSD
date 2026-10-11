package com.springboot.helpdesk.dto.Request;

import com.springboot.helpdesk.enums.PlanType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlanDto(
        @NotNull(message = "PlanType is required")
        PlanType planType,

        @NotNull(message = "Price is required")
        Double price
) {
}
