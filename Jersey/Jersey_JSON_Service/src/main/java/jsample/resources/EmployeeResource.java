package jsample.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jsample.model.Employee;
import jsample.service.EmployeeService;

@Path("/employee")
public class EmployeeResource {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") Integer id) {
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				return Response.ok().entity(EmployeeService.getInstance().getEmployeeList().get(i)).build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Employee with id " + id + " is not found").build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEmployeeById(@PathParam("id") Integer id) {
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				EmployeeService.getInstance().getEmployeeList().remove(i);
				return Response.status(Status.ACCEPTED).entity("Employee with id " + id + " is deleted.").build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Employee with id " + id + " is not found").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) {

		if (emp.getId() == null) {
			return Response.status(Status.BAD_REQUEST).entity("Employee id is not found").build();
		}
		EmployeeService.getInstance().getEmployeeList().add(emp);
		return Response.status(Status.OK).entity(emp).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") Integer id, Employee emp) {

		if (emp.getId() == null) {
			return Response.status(Status.BAD_REQUEST).entity("Employee id is not found").build();
		}
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				EmployeeService.getInstance().getEmployeeList().remove(i);
			}
		}
		EmployeeService.getInstance().getEmployeeList().add(emp);
		return Response.status(Status.OK).entity(emp).build();
	}
}