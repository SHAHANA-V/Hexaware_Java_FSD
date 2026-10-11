package com.mapper;

import com.dto.EmployeeRespDto;
import com.model.Employee;

public class EmployeeMapper {

    public static EmployeeRespDto mapModelToDto(Employee employee){

        return new EmployeeRespDto(
                employee.getId(),
                employee.getName(),
                employee.getBranch(),
                employee.getDepartment(),
                employee.getJoiningDate()
        );
    }
}
