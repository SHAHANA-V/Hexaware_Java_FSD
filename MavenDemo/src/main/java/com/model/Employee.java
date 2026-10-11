package com.model;

import com.enums.Branch;
import com.enums.Department;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private Branch branch;
    private String city;
    private Department department;
    private LocalDate joiningDate;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, Branch branch, String city, Department department, LocalDate joiningDate, double salary) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.city = city;
        this.department = department;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
