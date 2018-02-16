package jsample.camel;

import org.apache.camel.builder.RouteBuilder;

public class ProxyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("netty4-http:http://0.0.0.0:8888?matchOnUriPrefix=true").to("log:jsample?showHeaders=true")
				.toD("netty4-http:${header.Host}:80");
	}
}