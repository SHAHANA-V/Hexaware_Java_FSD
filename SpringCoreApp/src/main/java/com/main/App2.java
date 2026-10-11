package com.main;

import com.config.AppConfig;
import com.service.MyService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService2 myService2 = context.getBean(MyService2.class);
        myService2.test();
    }
}
