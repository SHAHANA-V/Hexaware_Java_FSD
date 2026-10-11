package com.helpdesk.main;

import com.helpdesk.Enum.JobTitle;
import com.helpdesk.Service.ExecutiveService;
import com.helpdesk.config.AppConfig;
import com.helpdesk.model.Executive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExecutiveController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExecutiveService executiveService = context.getBean(ExecutiveService.class);

        int managerId = 1;
        Executive executive = new Executive();
        executive.setName("Ron Harry");
        executive.setJobTitle(JobTitle.FIRST_LINE_SUPPORT);
        String username = "HarryRon@gmail.com";
        String password="Ginny@123";
        executiveService.insert(managerId, executive, username, password);
        System.out.println("Record inserted");

    }
}
/*
Spring's Context
--------
 ExecutiveService
 ExecutiveRepository
 EntityManager (persistence)
 UserRepository
* */