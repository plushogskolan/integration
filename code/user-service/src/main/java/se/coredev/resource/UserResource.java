package se.coredev.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import se.coredev.model.User;

@Path("users")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public final class UserResource {

	private static Map<Long, User> users = new HashMap<>();
	private static AtomicLong ids = new AtomicLong(1000);

	@Context
	private UriInfo uriInfo;

	@POST
	public Response addUser(User user) {
		Long id = ids.incrementAndGet();
		user = new User(id, user.getUsername(), user.getPassword(), user.getRoles());
		
		users.put(id, user);
		
		URI location = uriInfo.getAbsolutePathBuilder().path(id.toString()).build();
		
		return Response.created(location).build();
	}

	@GET
	public Collection<User> getAllUsers() {
		return users.values();
	}
	
//	@GET
//	public Response getAllUsers() {
//		
//		GenericEntity<Collection<User>> entity = new GenericEntity<Collection<User>>(users.values()){};
//		return Response.ok(entity).build();
//	}
	
	@GET
	@Path("{id}")
	public User getUser(@PathParam("id") Long id) {
//		User user = new User(1001L, "Master", "Yoda", new ArrayList<>()).addRole("master").addRole("admin");
		return users.get(id);
	}

}
