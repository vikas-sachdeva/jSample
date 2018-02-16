package jsample.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProxyRequestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String requestBody = (String) exchange.getIn().getBody();
		System.out.println("Request Logs - " + requestBody);
	}
}
