package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class UserFullDataEndpoint {

	@GET
	@Path("/users/{userId}")
	@Produces("application/json")
	public UserData getFullData(@PathParam("userId") String userId) {
		return null;
	}
}
