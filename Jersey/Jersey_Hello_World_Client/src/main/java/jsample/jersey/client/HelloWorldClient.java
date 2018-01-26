package jsample.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HelloWorldClient {

	private static final String SERVER_URL = "http://localhost:8080/Jersey_Hello_World/rest";

	private static final String API_PATH = "helloworld";

	public static void callRestApi(String param) {
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(SERVER_URL).path(API_PATH).path(param);

		Invocation.Builder invocationBuilder = webTarget.request();
		Response response = invocationBuilder.get();

		String responseText = response.readEntity(String.class);

		System.out.println("Response Received -\n" + responseText);

	}
}
