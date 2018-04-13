package jsample;

import jsample.spark.AppRoutes;

public class App {
	public static void main(String[] args) {
		AppRoutes route = new AppRoutes();
		route.registerRoutes();
		System.out.println("Server started");
	}
}
