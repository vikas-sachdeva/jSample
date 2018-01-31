package jsample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws SecurityException, FileNotFoundException, IOException {

		readLogConfigurationFile();

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				LOGGER.info("It is info log -  " + i);
			else
				LOGGER.warning("It is warn log - " + i);
		}
		LOGGER.severe("It is error log");
	}

	private static void readLogConfigurationFile() throws SecurityException, FileNotFoundException, IOException {

		LogManager.getLogManager().readConfiguration(App.class.getClassLoader().getResourceAsStream("log_config.properties"));

	}
}