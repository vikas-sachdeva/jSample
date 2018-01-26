package jsample.jersey;

import jsample.jersey.client.HelloWorldClient;

public class App {
	public static void main(String[] args) {
		HelloWorldClient.callRestApi("Jersey API");
	}
}
