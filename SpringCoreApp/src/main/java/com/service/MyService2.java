package com.service;

import com.dao.MyDao;
import com.mapper.TestMapper;
import com.utility.TestUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService2 {

    @Autowired
    private MyDao myDao;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestUtility testUtility;

    public void test(){
        myDao.test();
        testMapper.test();
        testUtility.test();
    }


}
