package com.model;

import com.Enum.Branch;
import com.Enum.Department;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{ // whenever the class is implemented with comparable always look into compareTo method and see on which basis it has been sorted
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
        this.salary=salary;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch=" + branch +
                ", city='" + city + '\'' +
                ", department=" + department +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee e2) {
        return this.joiningDate.compareTo(e2.joiningDate);// this sorts in asc order
        //this refers to e1 (it has the same logic of swapping using sorting like it is negative then swap, postive or equal keep it as it is)
        //for eg if we want to sort in desc order(((return e2.joiningDate.compareTo(this.joiningDate);)))
    }
}
