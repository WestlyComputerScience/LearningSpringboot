package com.johnteacher.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/post")
    public String post(@RequestBody String msg) {
        return "post message: " + msg;
    }

}
