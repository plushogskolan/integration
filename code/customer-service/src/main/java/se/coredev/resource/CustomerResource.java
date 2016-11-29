package se.coredev.resource;

import static se.coredev.model.CustomerParser.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.coredev.model.Customer;
import se.coredev.service.CustomerService;

@Component
@Path("customers")
public final class CustomerResource {

	@Autowired
	private CustomerService service;

	@POST
	public Response addCustmer(String value) {

		Customer customer = fromString(value);
		customer = service.createCustomer(customer);

		return Response.status(Status.CREATED)
		               .header("Location", "customers/" + customer.getId())
		               .build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getCustomerAsXml(@PathParam("id") Long id) {
		Customer customer = service.getCustomer(id);
		
		if (customer == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(asXml(customer)).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCustomerAsPlainText(@PathParam("id") Long id) {
		
		Customer customer = service.getCustomer(id);
		
		if (customer == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(asString(customer)).build();
	}

}
