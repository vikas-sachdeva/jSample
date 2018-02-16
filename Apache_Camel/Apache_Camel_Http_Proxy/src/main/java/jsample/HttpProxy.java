package jsample;

import jsample.camel.CamelProxyConfigurer;

public class HttpProxy {
	public static void main(String[] args) throws Exception {

		CamelProxyConfigurer camelConfigurer = new CamelProxyConfigurer();
		camelConfigurer.configure();

	}
}