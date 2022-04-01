package com.nsu.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/HelloWorld")
    public String returnHelloWorld(){
        return "Hello World";
    }
}