package com.springboot.crm.CRMProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.springboot.crm.CRMProject.model.Customer;
import com.springboot.crm.CRMProject.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	public String getAllCustomers(Model model) {
		List<Customer> customer= customerService.getAllCustomers();
		model.addAttribute("Customer",customer);
		return "index";
	}
	
	@RequestMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Customer customer=new Customer();
		model.addAttribute("Customer", customer);
		return "new_customer";
	
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customers/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		customerService.deleteById(id);
		return "redirect:/customers/list";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String formForUpdate(Model model,@RequestParam("id") int id) {
		//Book book = new Book();
		Customer customer = customerService.getCusById(id);
		model.addAttribute("Customer",customer);
		return "new_customer";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,Model model) {
		if(!firstName.isEmpty() || !lastName.isEmpty()) {
			List<Customer> customer = customerService.search(firstName, lastName);
			model.addAttribute("Customer",customer);
			return "index";
		}
		return "redirect:/customers/list";
	}
	

}
