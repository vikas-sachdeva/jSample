package jsample.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelProxyConfigurer {

	public void configure() throws Exception {
		CamelContext camelContext = new DefaultCamelContext();

		RouteBuilder streamRouteBuilder = new ProxyRouteBuilder();

		camelContext.addRoutes(streamRouteBuilder);

		camelContext.start();
		System.out.println("Http Proxy started.");
		Thread.sleep(1000 * 60 * 2);
		camelContext.stop();
		System.out.println("Http Proxy is stopping.");
	}

}
