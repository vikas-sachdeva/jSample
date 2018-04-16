package jsample.spark;

import spark.Spark;

public class AppRoutes {

	public void registerRoutes() {
		
		Spark.staticFileLocation("/webapp");
		Spark.redirect.get("/", "/html/hello.html");
		
		Spark.get("/getIp", (req, res) -> {
			
			String ipAddress = req.headers("HTTP_X_FORWARDED_FOR");

			if (ipAddress == null) {
				ipAddress = req.ip();
			}
			return ipAddress;

		});
	}
}