package jsample;

import java.util.logging.Logger;

/*
 * Java Logging configuration file path can be specified using VM arguments for customizing logging - 
 * 
 * -Djava.util.logging.config.file="./config/log_config.properties" 
 *
 */
public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  " + i);
			else
				LOGGER.warning("It is warn log - " + i);
		}
		LOGGER.severe("It is error log");
	}
}