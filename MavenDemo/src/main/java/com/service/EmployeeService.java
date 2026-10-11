package com.service;

import com.dto.EmployeeRespDto;
import com.enums.Department;
import com.enums.SortDirection;
import com.exception.InvalidListException;
import com.mapper.EmployeeMapper;
import com.model.Employee;

import java.util.List;

public class EmployeeService {
    public List<Employee> sortEmployeeBySalary(List<Employee> list, SortDirection direction) {
        if(list == null || list.isEmpty())
            throw new InvalidListException("List cannot be null or empty");

        if(direction.equals(SortDirection.ASC))
            list.sort((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())); //[50,80]
        else
            list.sort((e1,e2)-> (int)(e2.getSalary() - e1.getSalary()));

        return list;
    }

    public List<Employee> filterEmployeeByDepartment(List<Employee> list, Department department){
        if(list == null || list.isEmpty())
            throw new InvalidListException("List cannot be null or empty");

        return list.stream().filter(e->e.getDepartment().equals(department))
                .toList();
    }

    public List<String> getEmployeeNames(List<Employee> list){
        if(list == null || list.isEmpty())
            throw new InvalidListException("List cannot be null or empty");

        return list.stream().map(Employee::getName).toList();
    }

    public List<EmployeeRespDto> getEmployeeInfo(List<Employee> list){
        if(list == null || list.isEmpty())
            throw new InvalidListException("List cannot be null or empty");

        return  list.stream().map(EmployeeMapper::mapModelToDto).toList();
    }
}
