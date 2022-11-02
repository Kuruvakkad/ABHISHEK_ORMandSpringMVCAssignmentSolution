package com.springboot.crm.CRMProject.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.springboot.crm.CRMProject.model.Customer;

@Service
public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public void save(Customer customer);
	public void deleteById(int id);
	public List<Customer> search(String customerName, String department);
	public Customer getCusById(int id);

}
