package com.main;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {

        Map<String, String>map = new HashMap<>();
        map.put("Radha@gmail.com","radha456");
        map.put("Krishna@gmail.com","krishna478");

        map.entrySet().forEach(entry->{
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        });

        String value = map.get("Krishna@gmail.com");
        System.out.println(value);
    }
}
