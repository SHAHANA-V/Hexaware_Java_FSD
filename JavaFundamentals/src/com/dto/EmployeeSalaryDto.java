package com.dto;

import com.Enum.Branch;

public record EmployeeSalaryDto(
        Branch branch,
        double totalSalary
) {
}
