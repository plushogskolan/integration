package se.coredev.model;

import java.util.List;

import nu.xom.Document;
import nu.xom.Element;

public final class CustomerParser {

	public static Customer fromString(String value) {
		String[] parts = value.split(";");
		Long id = Long.parseLong(parts[0]);
		String firstName = parts[1];
		String lastName = parts[2];
		String number = parts[3];
		return new Customer(id, firstName, lastName, number);
	}

	// 1001;luke;skywlaker;lw-1001
	public static String asString(Customer customer) {

		return String.format("%s;%s;%s;%s", customer.getId(),
		                     customer.getFirstName(),
		                     customer.getLastName(),
		                     customer.getCustomerNumber());
	}

	public static String asXml(Customer customer) {
		Element root = createCustomerElement(customer);
		return new Document(root).toXML();
	}

	public static String asXml(List<Customer> customers) {
		Element root = new Element("customers");
		for (Customer customer : customers) {
			root.appendChild(createCustomerElement(customer));
		}
		return new Document(root).toXML();
	}

	private static Element createCustomerElement(Customer customer) {
		Element root = new Element("customer");
		root.appendChild(createElement("id", customer.getId().toString()));
		root.appendChild(createElement("firstName", customer.getFirstName()));
		root.appendChild(createElement("lastName", customer.getLastName()));
		root.appendChild(createElement("number", customer.getCustomerNumber()));
		return root;
	}

	private static Element createElement(String name, String value) {
		Element element = new Element(name);
		element.appendChild(value);
		return element;
	}

}
