package com.polinayantsen.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class SimpleRestController {

    @GetMapping("/")
    public String home() {
        return "Hello World! Time in the server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String workout() {
        return "Run a hard 5k!";
    }
}
