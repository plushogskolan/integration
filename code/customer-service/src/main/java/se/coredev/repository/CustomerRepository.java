package se.coredev.repository;

import java.util.List;

import se.coredev.model.Customer;

public interface CustomerRepository {

	void add(Customer customer);

	Customer get(Long id);

	void update(Customer customer);

	boolean delete(Long id);

	List<Customer> getAll();
}
