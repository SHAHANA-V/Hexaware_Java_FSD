package com.main;

import com.Enum.Branch;
import com.Enum.Department;
import com.Enum.SortDirection;
import com.dto.EmployeeRespDto;
import com.dto.EmployeeSalaryDto;
import com.dto.EmployeestatDto;
import com.model.Employee;
import com.service.EmployeeService;

import java.util.List;
import java.util.Map;

public class App {
    public static  void  main(String[] args){
        EmployeeService employeeService= new EmployeeService();
        List<Employee> list = employeeService.getAllEmployees();

       list.forEach(System.out :: println);
//
//        System.out.println("Employees salary in asc");
//
//        List<Employee> listSortedByAsc = employeeService.sortEmployeeBySalary(list, SortDirection.DESC);
//        listSortedByAsc.forEach(System.out::println);

//        System.out.println("-----Filter by Department-------");
//        List<Employee> listOfEmpByDepartment = employeeService.filterEmployeeByDepartment(list, Department.ADMIN);
//        listOfEmpByDepartment.forEach(System.out::println);
//
//        System.out.println("------Filter bt Branch-------");
//        List<Employee> listOfEmpByBranch = employeeService.filterEmployeeByBranch(list, Branch.MUMBAI);
//        listOfEmpByBranch.forEach(System.out::println);

//        List<String> listOfEmployeeNames = employeeService.getAllEmployeeNames(list);
//        listOfEmployeeNames.forEach(System.out::println);
//
//        List<EmployeeRespDto> listInfo=employeeService.getEmployeeInfo(list);
//        listInfo.forEach(System.out::println);

//             using normal map (same using dto is done below)
//        Map<Branch, Long> map= employeeService.getCountOfEmpByBranch(list);
//        System.out.println(map);

//        List<EmployeestatDto> listStatDto = employeeService.getCountOfEmpByDepartment(list);
//        listStatDto.forEach(System.out::println);

//        List<EmployeeSalaryDto> listSalaryDto= employeeService.getTotalSalaryByBranch(list);
//        listSalaryDto.forEach(System.out::println);
//
//        Double totalSalary = employeeService.getTotalSalary(listSalaryDto);
//        System.out.println("Total Salary: "+totalSalary);
    }
}
