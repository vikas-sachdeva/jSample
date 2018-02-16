package jsample.camel;

import org.apache.camel.builder.RouteBuilder;

public class ProxyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("netty4:tcp://0.0.0.0:9990").process(new ProxyRequestProcessor()).to("netty4:tcp://127.0.0.1:9999")
				.process(new ProxyResponseProcessor());
	}
}