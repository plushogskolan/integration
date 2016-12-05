package se.coredev.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import se.coredev.model.Customer;

@Component
public final class InMemoryCustomerRepository implements CustomerRepository {

	private final Map<Long, Customer> customers = new HashMap<>();

	{
		customers.put(1000L, new Customer(1000L, "Test", "Tester", "1000-ts"));
	}
	

	@Override
	public void add(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	@Override
	public Customer get(Long id) {
		return customers.get(id);
	}

	@Override
	public void update(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	@Override
	public boolean delete(Long id) {
		return customers.remove(id) != null;
	}

	@Override
	public List<Customer> getAll() {
		return new ArrayList<Customer>(customers.values());
	}
}
