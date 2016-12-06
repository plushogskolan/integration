package se.coredev.resource.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import se.coredev.model.User;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class UserMessageBodyWriter implements MessageBodyWriter<User> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return User.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(User t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(User user, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
	                    OutputStream entityStream)
	        throws IOException, WebApplicationException {
		PrintWriter writer = new PrintWriter(entityStream);
		writer.println(String.format("%s,%s,%s", user.getId(), user.getUsername(), user.getPassword()));
		writer.flush();
	}

}
