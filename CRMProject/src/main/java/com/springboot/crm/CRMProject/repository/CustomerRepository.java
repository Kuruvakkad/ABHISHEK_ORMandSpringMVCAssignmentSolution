package com.springboot.crm.CRMProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crm.CRMProject.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName, String lastName);
}