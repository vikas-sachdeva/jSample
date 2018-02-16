package jsample.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import jsample.camel.ServerRouteBuilder;

public class CamelServerConfigurer {

	public void configure() throws Exception {
		CamelContext camelContext = new DefaultCamelContext();

		RouteBuilder streamRouteBuilder = new ServerRouteBuilder();

		camelContext.addRoutes(streamRouteBuilder);

		camelContext.start();
		System.out.println("Tcp Server started.");
		Thread.sleep(1000 * 60 * 2);
		camelContext.stop();
		System.out.println("Tcp Server is stopping.");
	}

}
