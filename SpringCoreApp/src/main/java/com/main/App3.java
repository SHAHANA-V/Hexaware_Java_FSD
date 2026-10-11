package com.main;

import com.config.AppConfig;

import com.service.MyService3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService3 myService3 = context.getBean(MyService3.class);
        myService3.test();
    }
}
