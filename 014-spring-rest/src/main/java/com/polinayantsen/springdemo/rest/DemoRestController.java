package com.polinayantsen.springdemo.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
