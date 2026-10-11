package com.service;

import com.exception.EmptyListException;
import com.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {
    DemoService demoService;
    List<Double> listMarks1;
    List<Double> listMarks2;
    List<Double> listMarks3;
    List<Double> listMarks4;
    List<Double> listMarks5;
    List<Double> listMarks6;

    @BeforeEach
    public void setup(){
        System.out.println("Inside setup....");
        demoService= new DemoService();
        listMarks1 = List.of(78d,58d,86d,75d); // valid
        listMarks2 = List.of(78d,105d,86d,75d);// invalid - >100
        listMarks3 = List.of(78d,58d,86d,-3d);// invalid - <0
        listMarks4 = List.of(); // invalid - empty
        listMarks5 = List.of(78d,78d,86d,75d); // valid
        listMarks6 = List.of(68d,58d,56d,45d); // valid
    }

    @Test
    public void sumTest(){

        System.out.println("Inside test...");

        //both positive
        int actual = demoService.sum(5,6);
        int expected = 11;
        assertEquals(expected,actual);

        //one postive ,one negative
        actual = demoService.sum(5,-6);
        expected = -1;
        assertEquals(expected,actual);

        //one neg,one pos
        actual = demoService.sum(20,-10);
        expected = 10;
        assertEquals(expected,actual);

        //both negative
        actual = demoService.sum(-4,-5);
        expected = -9;
        assertEquals(expected,actual);
    }

    @Test
    public  void computeGradeTestFunctional(){
        assertNotNull(listMarks5);
        assertEquals("A",demoService.computeGrade(listMarks5));
        assertNotNull(listMarks1);
        assertEquals("B",demoService.computeGrade(listMarks1));
        assertNotNull(listMarks6);
        assertEquals("C",demoService.computeGrade(listMarks6));
        assertNotNull(listMarks6);
        assertNotEquals("A",demoService.computeGrade(listMarks6));

    }
    @Test
    public void computeGradeTestValidation(){

        //Null check - throwing Exception
        assertEquals("List cannot be null",
                assertThrows(NullPointerException.class,
                        () -> demoService.computeGrade(null)).
                        getMessage());

        //empty check - throwing emptyListException
        assertEquals("List has no elements",
                assertThrows(EmptyListException.class,
                        ()-> demoService.computeGrade(listMarks4))
                        .getMessage());

        //Incorrect Marks entry check - InvalidInputException below 0
        assertEquals("Marks should be between 0 to 100",
                assertThrows(InvalidInputException.class,
                        ()->demoService.computeGrade(listMarks3))
                        .getMessage());

        //Incorrect Marks entry check - InvalidInputException above 100
        assertEquals("Marks should be between 0 to 100",
                assertThrows(InvalidInputException.class,
                        ()->demoService.computeGrade(listMarks2))
                        .getMessage());
    }
    @AfterEach
    public void close(){
        System.out.println("Inside close...");
        demoService=null;
    }

}
