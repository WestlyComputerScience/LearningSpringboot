package com.johnteacher.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello") // gives us hello world in our browser
    public String helloWorld() {
        return "Hello World! Yessir";
    }

}
