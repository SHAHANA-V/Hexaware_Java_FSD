package com.main;

import com.config.AppConfig;
import com.dao.MyDao;
import com.mapper.TestMapper;
import com.service.MyService3;
import com.service.MyService4;
import com.utility.TestUtility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App4 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService4 myService4 = context.getBean(MyService4.class);
        myService4.test(context.getBean(MyDao.class),
                        context.getBean(TestMapper.class),
                         context.getBean(TestUtility.class));

        myService4.getClock();
    }
}
