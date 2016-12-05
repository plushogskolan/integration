package se.coredev.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

@Path("exception")
public final class ExceptionResource {

	@GET
	@Path("1")
	public String testException1(@QueryParam("message") String message) {
		if ("abc".equals(message)) {
			throw new WebApplicationException(message + " is a bad message", Status.BAD_REQUEST);
		}
		return message;
	}
	
	
	@GET
	@Path("2")
	public String testException2(@QueryParam("message") String message) {
		if ("abc".equals(message)) {
			throw new BadMessageException(message);
		}
		return message;
	}
	
	@GET
	@Path("3")
	public String testException3(@QueryParam("message") String message) {
		if ("abc".equals(message)) {
			throw new MessageException(message + " is a bad message");
		}
		return message;
	}
	

	
}
