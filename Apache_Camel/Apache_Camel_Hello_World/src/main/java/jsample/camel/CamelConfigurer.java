package jsample.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import jsample.camel.StreamRouteBuilder;

public class CamelConfigurer {

	public void configure() throws Exception {
		CamelContext camelContext = new DefaultCamelContext();

		RouteBuilder streamRouteBuilder = new StreamRouteBuilder();

		camelContext.addRoutes(streamRouteBuilder);

		camelContext.start();
		System.out.println("Type your message -");
		Thread.sleep(1000 * 60 * 2);
		camelContext.stop();
		System.out.println("System is stopping now.");
	}

}
