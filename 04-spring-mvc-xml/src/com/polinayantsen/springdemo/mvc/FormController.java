package com.polinayantsen.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class FormController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "form";
    }

    @RequestMapping("/processFormVersionOne")
    public String processForm(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        model.addAttribute("message", "Yo! " + name.toUpperCase());
        return "hello";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processFormVersionTwo(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("message", "Hello! " + name.toUpperCase());
        return "hello";
    }
}
