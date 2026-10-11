package com.service;

import com.dao.MyDao;
import com.mapper.TestMapper;
import com.utility.TestUtility;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
public class MyService4 {

    private final Clock clock;

    public MyService4(Clock clock) {
        this.clock = clock;
    }

    public void test(MyDao myDao, TestMapper testMapper, TestUtility testUtility){
        myDao.test();
        testMapper.test();
        testUtility.test();

    }

    public void getClock(){
        System.out.println("Time is: "+clock.instant());
    }
}
