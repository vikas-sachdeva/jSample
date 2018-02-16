package jsample;

import jsample.camel.CamelServerConfigurer;

public class TcpServer {
	public static void main(String[] args) throws Exception {

		CamelServerConfigurer camelConfigurer = new CamelServerConfigurer();
		camelConfigurer.configure();

	}
}