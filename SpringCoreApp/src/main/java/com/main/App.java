package com.main;

import com.config.AppConfig;
import com.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        // From here we need to ensure that our AppConfig class loads
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("App works");
        /*
                 ApplicationContext
                      | implements
               AnnotationConfigApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); -- Polymorphic
         * */

        // reach to service class
        MyService myService = context.getBean(MyService.class);
        myService.test();
    }
}
