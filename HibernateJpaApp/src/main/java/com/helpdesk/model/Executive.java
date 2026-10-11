package com.helpdesk.model;

import com.helpdesk.Enum.JobTitle;
import jakarta.persistence.*;

@Entity
public class Executive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "manager_id",nullable = false)
    private Manager manager;

    @OneToOne
    private User user;

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

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Executive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobTitle=" + jobTitle +
                ", manager=" + manager +
                ", user=" + user +
                '}';
    }
}
