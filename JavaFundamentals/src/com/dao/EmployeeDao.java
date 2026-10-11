package com.dao;

import com.Enum.Branch;
import com.Enum.Department;
import com.model.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeDao {
    public List<Employee> getAllEmployees(){
        return Arrays.asList(
                new Employee(1, "Aarav Sharma", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2021, 3, 12), 85000.0),
                new Employee(2, "Priya Nair", Branch.CHENNAI, "Chennai", Department.FINANCE, LocalDate.of(2022, 5, 18), 72000.0),
                new Employee(3, "Rahul Verma", Branch.NEW_YORK, "New York", Department.ADMIN, LocalDate.of(2020, 8, 25), 95000.0),
                new Employee(4, "Sneha Iyer", Branch.CHENNAI, "Chennai", Department.DEV, LocalDate.of(2023, 1, 10), 68000.0),
                new Employee(5, "Vikram Singh", Branch.MUMBAI, "Mumbai", Department.ADMIN, LocalDate.of(2019, 11, 5), 78000.0),
                new Employee(6, "Divya Menon", Branch.NEW_YORK, "New York", Department.FINANCE, LocalDate.of(2021, 7, 22), 88000.0),
                new Employee(7, "Karthik Raj", Branch.CHENNAI, "Chennai", Department.DEV, LocalDate.of(2024, 2, 14), 62000.0),
                new Employee(8, "Meera Krishnan", Branch.MUMBAI, "Mumbai", Department.FINANCE, LocalDate.of(2022, 9, 30), 76000.0),
                new Employee(9, "Aditya Kapoor", Branch.NEW_YORK, "New York", Department.DEV, LocalDate.of(2020, 4, 17), 105000.0),
                new Employee(10, "Ananya Reddy", Branch.CHENNAI, "Chennai", Department.ADMIN, LocalDate.of(2023, 6, 8), 59000.0),
                new Employee(11, "Rohan Gupta", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2021, 12, 1), 91000.0),
                new Employee(12, "Kavya Srinivas", Branch.NEW_YORK, "New York", Department.FINANCE, LocalDate.of(2019, 10, 19), 98000.0),
                new Employee(13, "Arjun Mehta", Branch.CHENNAI, "Chennai", Department.DEV, LocalDate.of(2022, 3, 7), 73000.0),
                new Employee(14, "Pooja Shah", Branch.MUMBAI, "Mumbai", Department.ADMIN, LocalDate.of(2024, 4, 21), 61000.0),
                new Employee(15, "Naveen Kumar", Branch.NEW_YORK, "New York", Department.DEV, LocalDate.of(2020, 12, 15), 102000.0),
                new Employee(16, "Ishita Bose", Branch.CHENNAI, "Chennai", Department.FINANCE, LocalDate.of(2023, 8, 11), 69000.0),
                new Employee(17, "Siddharth Rao", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2021, 5, 27), 87000.0),
                new Employee(18, "Neha Agarwal", Branch.NEW_YORK, "New York", Department.ADMIN, LocalDate.of(2022, 11, 3), 82000.0),
                new Employee(19, "Varun Malhotra", Branch.CHENNAI, "Chennai", Department.FINANCE, LocalDate.of(2020, 6, 16), 79000.0),
                new Employee(20, "Riya Patel", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2024, 1, 29), 65000.0)
        );
    }
}
