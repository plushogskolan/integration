package se.coredev.resource;

import static se.coredev.model.CustomerParser.asXml;
import static se.coredev.model.CustomerParser.fromString;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.coredev.model.Customer;
import se.coredev.service.CustomerService;

@Component
@Path("customers")
@Produces(MediaType.APPLICATION_XML)
public final class CustomerResource {

	@Autowired
	private CustomerService service;

	@Context
	private UriInfo uriInfo;
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response addCustomer(String value) {

		Customer customer = fromString(value);
		customer = service.createCustomer(customer);
		
//		URI location = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();
		URI location = uriInfo.getAbsolutePathBuilder().path(CustomerResource.class, "getCustomer").build(customer.getId());
		
		return Response.created(location).build();		
	}

	@GET
	public Response getAllCustomers(@QueryParam("size") @DefaultValue("5") int size,
	                                @QueryParam("sort") @DefaultValue("asc") String sort) {
		
		List<Customer> customers = service.getAllCustomers();
		customers = customers.subList(0, Math.min(customers.size(), size));
		customers.sort((c1, c2) -> sort.equalsIgnoreCase("desc") ? Long.compare(c1.getId(), c2.getId()) : 
																   Long.compare(c2.getId(), c1.getId()));
		
		return Response.ok(asXml(customers)).build();
	}
	
	@GET
	@Path("{id}")
	public Response getCustomer(@PathParam("id") Long id) {
		Customer customer = service.getCustomer(id);
		
		if (customer == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(asXml(customer)).build();
	}
}
