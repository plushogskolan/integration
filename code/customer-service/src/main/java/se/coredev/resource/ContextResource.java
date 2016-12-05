package se.coredev.resource;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

@Path("context")
public final class ContextResource {

	@Context
	private UriInfo uriInfo;

	@Context
	private HttpHeaders headers;

	private @HeaderParam("api-key") String apiKey;
	
	@GET
	@Path("headers")
	public String displayApiHeader() {		
		return headers.getHeaderString("api-key");
	}
	
	@GET
	@Path("header")
	public String displayHeader() {
		return apiKey == null ? "not found" : "found";
	}

	@GET
	@Path("builder")
	public String uriBuilderTest() {
		StringBuilder result = new StringBuilder();

		result.append("Path:").append(uriInfo.getPath());
		result.append("\nAbsolute path:").append(uriInfo.getAbsolutePath());
		result.append("\nBase uri:").append(uriInfo.getBaseUri());
		result.append("\nRequest uri:").append(uriInfo.getRequestUri());
		result.append("\nPath segments:").append(uriInfo.getPathSegments());

		return result.toString();
	}

	@GET
	@Path("uriinfo")
	public String testUriInfo() {
		StringBuilder result = new StringBuilder();

		for (Entry<String, List<String>> entry : uriInfo.getQueryParameters().entrySet()) {
			result.append(entry.getKey()).append(":");
			for (String value : entry.getValue()) {
				result.append(value).append(" ");
			}
			result.append("\n");
		}

		return result.toString();
	}

}
