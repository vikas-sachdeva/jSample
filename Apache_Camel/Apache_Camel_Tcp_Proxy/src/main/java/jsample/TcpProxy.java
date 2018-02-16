package jsample;

import jsample.camel.CamelProxyConfigurer;

public class TcpProxy {
	public static void main(String[] args) throws Exception {

		CamelProxyConfigurer camelConfigurer = new CamelProxyConfigurer();
		camelConfigurer.configure();

	}
}