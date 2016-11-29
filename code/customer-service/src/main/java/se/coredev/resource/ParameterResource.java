package se.coredev.resource;



import javax.ws.rs.BeanParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import se.coredev.model.PageRequestBean;
import se.coredev.model.Point;

@Path("parameters")
public final class ParameterResource {

	// paramaters/test1?value=hello
	@GET
	@Path("test1")
	public String test1(@QueryParam("value") @DefaultValue("no_value") String value){
		return "Value: " + value;
	}
	
	@GET 
	@Path("test2")
	public String test2(@BeanParam PageRequestBean request){
		return String.format("page:%d, size:%d, sort:%s", request.getPage(), request.getSize(), request.getSort());
	}
	
	@GET
	@Path("test3")
	public String test3(@QueryParam("point") Point point){
		return String.format("x:%d, y:%d", point.getX(), point.getY());
	}
}
