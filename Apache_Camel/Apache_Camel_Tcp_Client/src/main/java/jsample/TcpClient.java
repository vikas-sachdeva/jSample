package jsample;

import jsample.camel.CamelClientConfigurer;

public class TcpClient {
	public static void main(String[] args) throws Exception {

		CamelClientConfigurer camelConfigurer = new CamelClientConfigurer();
		camelConfigurer.configure();

	}
}