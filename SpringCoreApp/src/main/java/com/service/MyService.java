package com.service;

import com.dao.MyDao;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    // reach out to dao
    // MyDao myDao = new MyDao(); //POJO - self managed
    private final MyDao myDao;// managed by spring

    public MyService(MyDao myDao) {
        this.myDao = myDao;
    }

    public void test(){
        myDao.test();
    }
}
