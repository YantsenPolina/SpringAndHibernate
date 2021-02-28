package com.polinayantsen.springdemo.controller;

import com.polinayantsen.springdemo.entity.Customer;
import com.polinayantsen.springdemo.service.CustomerService;
import com.polinayantsen.springdemo.util.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model, @RequestParam(required = false) String sort) {
        List<Customer> customers = null;
        if (sort != null) {
            int sortField = Integer.parseInt(sort);
            customers = customerService.getCustomers(sortField);
        } else {
            customers = customerService.getCustomers(SortUtils.LAST_NAME);
        }
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {
        List<Customer> customers = customerService.searchCustomers(searchName);
        model.addAttribute("customers", customers);
        return "list-customers";
    }
}
