package jsample.camel;

import org.apache.camel.builder.RouteBuilder;

public class ClientRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("stream:in").to("netty4:tcp://127.0.0.1:9990").to("stream:out");
	}
}