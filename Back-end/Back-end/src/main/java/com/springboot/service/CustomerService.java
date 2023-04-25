package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Customer;
import com.springboot.repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}

	public Customer loginCustomer(Customer customer)
	{
		return customerRepository.findByEmailIDAndPassword(customer.emailID, customer.password)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id",
						customer.emailID + "And password" + customer.password));
	}

	public Customer updateCustomer(Customer customer, long customerId)
	{
		Customer eCustomer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
		eCustomer.setFirstName(customer.getFirstName());
		eCustomer.setLastName(customer.getLastName());
		eCustomer.setDateOfBirth(customer.getDateOfBirth());
		eCustomer.setPhoneNumber(customer.getPhoneNumber());
		eCustomer.setState(customer.getState());
		eCustomer.setZipCode(customer.getZipCode());
		eCustomer.setEmailID(customer.getEmailID());
		eCustomer.setGender(customer.getGender());
		eCustomer.setPassword(customer.getPassword());

		customerRepository.save(eCustomer);

		return eCustomer;
	}

	public Customer getCustomerById(long customerId)
	{
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
	}

	public Customer getCustomerByEmail(Customer customer)
	{
		return customerRepository.findByEmailID(customer.emailID)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customer.emailID));
	}

	public void deleteCustomer(long customerId)
	{
		customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
		customerRepository.deleteById(customerId);
	}

	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
	}

}
