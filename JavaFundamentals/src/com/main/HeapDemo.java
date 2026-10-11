package com.main;

import com.beans.Customer;

public class HeapDemo {
    public static void main() {

        Customer c1=new Customer(1,"Harry",21);

        Customer c2=new Customer();
        c2.setId(2);
        c2.setName("Hermonie");
        c2.setAge(24);

        Customer c3= c1;// it also refer to the object in the same memory location as c1

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());

        c1.setName("Ronald");
        System.out.println(c1.getName());
        System.out.println(c3.getName());

        //to see memory locations
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }
}
