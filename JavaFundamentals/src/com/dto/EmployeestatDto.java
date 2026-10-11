package com.dto;

import com.Enum.Department;

public record EmployeestatDto(
        Department department,
        Long NumberOfEmployees
) {
}
