package jsample.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import jsample.camel.ProxyRouteBuilder;

public class CamelProxyConfigurer {

	public void configure() throws Exception {
		CamelContext camelContext = new DefaultCamelContext();

		RouteBuilder streamRouteBuilder = new ProxyRouteBuilder();

		camelContext.addRoutes(streamRouteBuilder);

		camelContext.start();
		System.out.println("Tcp Proxy started.");
		Thread.sleep(1000 * 60 * 2);
		camelContext.stop();
		System.out.println("Tcp Proxy is stopping.");
	}

}
