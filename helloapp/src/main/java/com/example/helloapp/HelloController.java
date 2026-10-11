package com.example.helloapp;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class HelloController {
    @GetMapping("/helloworld")
    public String sayHello(){
        return "Hello World";
    }
}
