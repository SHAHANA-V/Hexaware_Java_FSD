package com.helpdesk.model;

import com.helpdesk.enums.Plan;

public class Customer {
    private int id;
    private String name;
    private int age;
    private Plan plan;

    private Users users;

    public Customer() {
    }

    public Customer(int id, String name, int age, Plan plan, Users users) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.plan = plan;
        this.users = users;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", plan=" + plan +
                ", users=" + users +
                '}';
    }
}
