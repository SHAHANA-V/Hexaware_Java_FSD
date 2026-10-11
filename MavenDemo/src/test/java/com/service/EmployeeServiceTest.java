package com.service;

import com.dto.EmployeeRespDto;
import com.enums.Branch;
import com.enums.Department;
import com.enums.SortDirection;
import com.exception.InvalidListException;
import com.model.Employee;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    List<Employee> list;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private Employee employee6;
    private Employee employee7;
    private Employee employee8;
    private EmployeeRespDto employeeRespDto1;
    private EmployeeRespDto employeeRespDto2;
    private EmployeeRespDto employeeRespDto3;

    @BeforeEach
    public  void setup(){
        employeeService =new EmployeeService();
        employee1 = new Employee(1, "Aarav Sharma", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2021, 3, 12), 85000.0);
        employee2=  new Employee(2, "Priya Nair", Branch.CHENNAI, "Chennai", Department.FINANCE, LocalDate.of(2022, 5, 18), 72000.0);
        employee3 = new Employee(3, "Rahul Verma", Branch.NEW_YORK, "New York", Department.ADMIN, LocalDate.of(2020, 8, 25), 95000.0);
        employee4 = new Employee(4, "Sneha Iyer", Branch.CHENNAI, "Chennai", Department.DEV, LocalDate.of(2023, 1, 10), 68000.0);
        employee5 = new Employee(5, "Vikram Singh", Branch.MUMBAI, "Mumbai", Department.ADMIN, LocalDate.of(2019, 11, 5), 78000.0);
        employee6 = new Employee(6, "Divya Menon", Branch.NEW_YORK, "New York", Department.FINANCE, LocalDate.of(2021, 7, 22), 88000.0);
        employee7 = new Employee(7, "Karthik Raj", Branch.CHENNAI, "Chennai", Department.DEV, LocalDate.of(2024, 2, 14), 62000.0);
        employee8 = new Employee(8, "Meera Krishnan", Branch.MUMBAI, "Mumbai", Department.FINANCE, LocalDate.of(2022, 9, 30), 76000.0);
        list = Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8);

        employeeRespDto1 = new EmployeeRespDto(1,"Aarav Sharma",Branch.MUMBAI,Department.DEV, LocalDate.of(2021, 3, 12));
        employeeRespDto2 = new EmployeeRespDto(2, "Priya Nair" ,  Branch.CHENNAI,Department.FINANCE, LocalDate.of(2022, 5, 18));
        employeeRespDto3 = new EmployeeRespDto(3, "Rahul Verma" , Branch.NEW_YORK,Department.ADMIN, LocalDate.of(2020, 8, 25));
    }

    @Test
    public void sortEmployeeBySalaryTest(){
        assertThrows(InvalidListException.class,()->employeeService.sortEmployeeBySalary(null, SortDirection.ASC));
        assertThrows(InvalidListException.class,()->employeeService.sortEmployeeBySalary(List.of(), SortDirection.ASC));

        List<Employee>expectedList= List.of(employee7,employee4,employee2,employee8,employee5,employee1,employee6,employee3);
        assertEquals(expectedList , employeeService.sortEmployeeBySalary(list , SortDirection.ASC));

        assertEquals(expectedList.reversed() , employeeService.sortEmployeeBySalary(list , SortDirection.DESC));

    }

    @Test
    public void filterEmployeeByDepartmentTest(){
        assertThrows(InvalidListException.class,()->employeeService.filterEmployeeByDepartment(null,Department.DEV));
        assertThrows(InvalidListException.class,()->employeeService.filterEmployeeByDepartment(List.of(),Department.ADMIN));

        List<Employee> expectedListByDepartment =List.of(employee3,employee5);
        assertEquals(expectedListByDepartment, employeeService.filterEmployeeByDepartment(list,Department.ADMIN));
    }

    @Test
    public void getEmployeeNamesTest(){

        assertThrows(InvalidListException.class, ()-> employeeService.getEmployeeInfo(null));
        assertThrows(InvalidListException.class, ()-> employeeService.getEmployeeInfo(List.of()));

        List<String> expectedEmployeeNames=List.of("Aarav Sharma","Priya Nair","Rahul Verma","Sneha Iyer","Vikram Singh","Divya Menon","Karthik Raj","Meera Krishnan");
        assertEquals(expectedEmployeeNames,employeeService.getEmployeeNames(list));
    }

    @Test
    public void getEmployeeInfoTest(){
        assertThrows(InvalidListException.class, ()-> employeeService.getEmployeeInfo(null));
        assertThrows(InvalidListException.class, ()-> employeeService.getEmployeeInfo(List.of()));

        assertEquals( List.of(employeeRespDto1,employeeRespDto2, employeeRespDto3),
                employeeService.getEmployeeInfo(List.of(employee1,employee2,employee3)));

    }
    @AfterEach
    public void destroy(){
        employeeService = null;
        employee1 = null;
        employee2 = null;
        employee3 = null;
        employee4 = null;
        employee5 = null;
        employee6 = null;
        employee7 = null;
        list = null;
        employeeRespDto1=null;
        employeeRespDto2=null;
        employeeRespDto3=null;
    }
}
