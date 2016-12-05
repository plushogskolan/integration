package se.coredev.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import se.coredev.resource.ContextResource;
import se.coredev.resource.CustomerResource;
import se.coredev.resource.ExceptionResource;
import se.coredev.resource.MessageExceptionMapper;
import se.coredev.resource.ParameterResource;

@Component
public final class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CustomerResource.class);
		register(ParameterResource.class);
		register(ContextResource.class);
		register(ExceptionResource.class);
		register(MessageExceptionMapper.class);
	}
}
