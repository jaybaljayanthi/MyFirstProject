package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.models.Customer;

@Controller
public class CustomerController {
	
	@RequestMapping(value="/all/registrationform")
	public String getRegistrationForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "registrationform";
	}
	
	
	@RequestMapping(value="/all/registercustomer")
	public String registerCustomer(@ModelAttribute(name="customer") Customer customer) {
		
		System.out.println("customer");
		return "login";
	}
}
