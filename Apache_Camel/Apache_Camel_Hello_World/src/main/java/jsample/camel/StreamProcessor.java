package jsample.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class StreamProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String requestBody = (String) exchange.getIn().getBody();
		// Get Request Body and prepend our message and then send it to output component
		String responseBody = "Camel - " + requestBody;
		exchange.getOut().setBody(responseBody);
	}
}
