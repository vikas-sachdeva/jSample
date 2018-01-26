package jsample.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jsample.jersey.model.Employee;

public class EmployeeClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_Json_Service/rest";

	private static final String API_PATH = "employee";

	public static void getEmployeeWithId(Integer id) {
		System.out.println("\nRequesting employee information...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println("Response Received-\n" + employee);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}

	}

	public static void deleteEmployeeWithId(Integer id) {
		System.out.println("\nRequesting employee deletion...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		String responseText = response.readEntity(String.class);
		System.out.println("Response Received-\n" + responseText);

	}

	public static void createEmployee(Employee emp) {
		System.out.println("\nRequesting employee addition...");
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH);

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(emp, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println("Response Received-\n" + employee);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}
	}

	public static void updateEmployee(Integer id, Employee emp) {
		System.out.println("\nRequesting employee updation...");
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(emp, MediaType.APPLICATION_JSON));

		if (response.getStatusInfo().equals(Status.OK)) {
			Employee employee = response.readEntity(Employee.class);
			System.out.println("Response Received-\n" + employee);
		} else {
			String responseText = response.readEntity(String.class);
			System.out.println("Response Received-\n" + responseText);
		}
	}
}
