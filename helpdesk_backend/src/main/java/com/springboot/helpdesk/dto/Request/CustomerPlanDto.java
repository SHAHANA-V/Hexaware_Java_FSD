package com.springboot.helpdesk.dto.Request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CustomerPlanDto(

        LocalDate activationDate,
        @NotNull(message = "Activation date is required")
        LocalDate endDate,
        String coupon,
        @NotNull(message = "Paid Amount is required")
        Double amountPaid
) {
}
