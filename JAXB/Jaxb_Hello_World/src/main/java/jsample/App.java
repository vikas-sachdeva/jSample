package jsample;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jsample.conf.Configuration;

public class App 
{
	private static final String CONF_FILE_PATH = "./xml/config.xml";

	public static void main(String[] args) throws JAXBException, IOException {

		Configuration configuration = unmarshal();
		marshal(configuration);
	}

	private static void marshal(Configuration configuration) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Configuration.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		System.out.println("Configuration File is -");
		marshaller.marshal(configuration, System.out);
	}

	private static Configuration unmarshal() throws JAXBException, IOException {
		File file = new File(CONF_FILE_PATH);
		JAXBContext context = JAXBContext.newInstance(Configuration.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Configuration configurationObject = (Configuration) unmarshaller.unmarshal(file);
		System.out.println("Configuration Object is -\n" + configurationObject);
		return configurationObject;
	}
}
