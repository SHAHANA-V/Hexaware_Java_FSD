package com.service;

import com.exception.EmptyListException;
import com.exception.InvalidInputException;

import java.util.List;

public class DemoService {

    public int sum(int x,int y){
        return x+y;
    }

    public String computeGrade(List<Double> list){
        //Focus on validation--second priority
        if(list==null)
            throw new NullPointerException("List cannot be null");

        if(list.isEmpty())
            throw new EmptyListException("List has no elements");

        long incorrectEntries = list.stream().filter(e-> e > 100 || e < 0).count();
        if(incorrectEntries > 0)
            throw new InvalidInputException("Marks should be between 0 to 100");

        //focus on functionality--first priority
        double totalMarks = list.stream().mapToDouble(m-> m).sum();
        int totalSub = list.size();

        double percentage = totalMarks / totalSub;

        if(percentage >= 75)
            return "A";
        if(percentage >=60)
            return "B";
        return "C";


    }
}
