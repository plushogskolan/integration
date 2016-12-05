package se.coredev.resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public final class BadMessageException extends WebApplicationException {

	private static final long serialVersionUID = -3172713362027119376L;

	public BadMessageException(String message) {
		super(Response.status(Status.BAD_REQUEST).entity(message + " is a bad message").build());
	}
}
