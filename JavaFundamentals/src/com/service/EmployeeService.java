package com.service;

import com.Enum.Branch;
import com.Enum.Department;
import com.Enum.SortDirection;
import com.dao.EmployeeDao;
import com.dto.EmployeeRespDto;
import com.dto.EmployeeSalaryDto;
import com.dto.EmployeestatDto;
import com.mapper.EmployeeMapper;
import com.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService {
    private EmployeeDao employeeDao=new EmployeeDao();

    public List<Employee> getAllEmployees() {

        //return employeeDao.getAllEmployees(); --returns in a normal order
        List<Employee> list = employeeDao.getAllEmployees(); //unsorted list
        Collections.sort(list); //sorting done with default sort- refer model class for logic -- see the compareTo method that has been overrided
        return list;
    }


    public List<Employee> sortEmployeeBySalary(List<Employee> list, SortDirection sortDirection) {
        if(sortDirection.equals(SortDirection.ASC)){
            list.sort((e1,e2)->(int)(e1.getSalary() - e2.getSalary()));
        }
        else{
            list.sort((e1,e2)->(int)(e2.getSalary() - e1.getSalary()));
        }
        return  list;
    }

    public List<Employee> filterEmployeeByDepartment(List<Employee> list, Department department) {

        //step1----convert list to stream for faster speed
        Stream<Employee> stream = list.stream();

        //step2----perform the operation
        stream=stream.filter(e-> e.getDepartment().equals(department));

        //step3--- reconvert to list
        return stream.toList();
    }

    public List<Employee> filterEmployeeByBranch(List<Employee> list, Branch branch) {

        return  list.stream().filter(e-> e.getBranch().equals(branch)).toList();
    }


    public List<String> getAllEmployeeNames(List<Employee> list) {

        return list.stream().map(Employee::getName).toList();
    }
    public  List<EmployeeRespDto> getEmployeeInfo(List<Employee> list){
        return  list.stream().map(EmployeeMapper::mapModelToDto).toList();
    }

    public Map<Branch,Long> getCountOfEmpByBranch(List<Employee> list) {
        return list
                .stream()
                .collect(Collectors.groupingBy(Employee::getBranch,Collectors.counting()));
    }

    public List<EmployeestatDto> getCountOfEmpByDepartment(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry->new EmployeestatDto(entry.getKey(),entry.getValue()))
                .toList();
    }

    public List<EmployeeSalaryDto> getTotalSalaryByBranch(List<Employee> list) {
        return
                list.stream()
                .collect(Collectors.groupingBy(Employee::getBranch,Collectors.summingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .map(entry->new EmployeeSalaryDto(entry.getKey(), entry.getValue()))
                .toList();
    }

    public Double getTotalSalary(List<EmployeeSalaryDto> listSalaryDto) {
        return listSalaryDto.stream().mapToDouble(EmployeeSalaryDto::totalSalary).sum();

        //also be listSalaryDto.stream()
        //                .collect(Collectors.summingDouble(EmployeeSalaryDto::totalSalary))
    }
}
