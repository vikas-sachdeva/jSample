package jsample.camel;

import org.apache.camel.builder.RouteBuilder;

public class ServerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("netty4:tcp://0.0.0.0:9999").process(new ServerProcessor());
	}
}