package com.polinayantsen.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/leaders")
    public String leaders() {
        return "leaders";
    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }
}
