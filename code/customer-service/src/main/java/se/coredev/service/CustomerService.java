package se.coredev.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.coredev.model.Customer;
import se.coredev.repository.CustomerRepository;

@Component
public final class CustomerService {

	private final CustomerRepository customerRepository;
	private final AtomicLong customerIds = new AtomicLong(1000);

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer createCustomer(Customer customer) {

		Long id = customerIds.incrementAndGet();
		Customer c = new Customer(id, customer.getFirstName(), customer.getLastName(), customer.getCustomerNumber());
		customerRepository.add(c);

		return c;
	}

	public Customer getCustomer(Long id) {
		return customerRepository.get(id);
	}

	public Customer updateCustomer(Customer customer) {
		customerRepository.update(customer);
		return customer;
	}

	public boolean deleteCustomer(Long id) {
		return customerRepository.delete(id);
	}

}