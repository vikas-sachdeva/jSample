package jsample.spark;

import spark.Spark;

public class AppRoutes {

	public void registerRoutes() {
		Spark.get("/hello", (req, res) -> "Hello World");
	}

}
