package se.coredev;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import se.coredev.resource.UserResource;
import se.coredev.resource.writer.UserMessageBodyWriter;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(UserResource.class);
		register(UserMessageBodyWriter.class);
	}

}
