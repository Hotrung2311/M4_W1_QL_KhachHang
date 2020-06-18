package com.codegym.controller;

import com.codegym.models.Customer;
import com.codegym.service.CustomerServiceImpl;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    private ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String email, @RequestParam String address){
        customerService.save(new Customer(20, name, email, address));
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }
}
