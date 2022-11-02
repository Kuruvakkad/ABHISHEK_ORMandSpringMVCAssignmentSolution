package com.springboot.crm.CRMProject.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crm.CRMProject.model.Customer;
import com.springboot.crm.CRMProject.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);

	}

	@Override
	public void deleteById(int id) {
		Customer customer = getCusById(id);
		customerRepository.delete(customer);

	}

	@Override
	public List<Customer> search(String firstName, String lastName) {

		return customerRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
	}

	@Override
	public Customer getCusById(int id) {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if (optCustomer.isPresent()) {
			return optCustomer.get();
		}
		return null;

	}

}
