package com.dto;

import com.Enum.Branch;
import com.Enum.Department;

import java.time.LocalDate;

public record EmployeeRespDto(
        int id,
        String name,
        Branch branch,
        Department department,
        LocalDate joiningDate
) {
}
