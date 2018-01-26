package jsample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class HelloWorldResource {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Hello World : " + msg;

		return Response.status(200).entity(output).build();

	}

}
