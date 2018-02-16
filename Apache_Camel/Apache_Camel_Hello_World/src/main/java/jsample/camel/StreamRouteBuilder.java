package jsample.camel;

import org.apache.camel.builder.RouteBuilder;

public class StreamRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("stream:in").process(new StreamProcessor()).to("stream:err");
	}
}
