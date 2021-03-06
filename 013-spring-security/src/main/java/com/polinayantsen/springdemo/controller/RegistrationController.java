package com.polinayantsen.springdemo.controller;

import com.polinayantsen.springdemo.entity.User;
import com.polinayantsen.springdemo.service.UserService;
import com.polinayantsen.springdemo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/registrationForm")
    public String showMyLoginPage(Model model) {
        model.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser crmUser,
            BindingResult bindingResult,
            Model model) {
        String userName = crmUser.getUserName();
        logger.info("Processing registration form for " + userName);
        if (bindingResult.hasErrors()){
            return "registration-form";
        }
        User existing = userService.findByUserName(userName);
        if (existing != null){
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name already exists");
            logger.warning("User name already exists");
            return "registration-form";
        }
        userService.save(crmUser);
        logger.info("Successfully created user: " + userName);
        return "registration-confirmation";
    }
}
