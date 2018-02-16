package jsample.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelClientConfigurer {

	public void configure() throws Exception {
		CamelContext camelContext = new DefaultCamelContext();

		RouteBuilder streamRouteBuilder = new ClientRouteBuilder();

		camelContext.addRoutes(streamRouteBuilder);

		camelContext.start();
		System.out.println("Type your message to send it to server -");
		Thread.sleep(1000 * 60 * 2);
		camelContext.stop();
		System.out.println("Tcp Client is stopping.");
	}

}
