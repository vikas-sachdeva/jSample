package jsample.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProxyResponseProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String requestBody = (String) exchange.getIn().getBody();
		System.out.println("Response Logs - " + requestBody);
	}
}
