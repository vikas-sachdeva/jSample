package jsample.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * XML Root element name and the name of the fields declared in the class should
 * be exactly same as defined in XML file. Name is case-sensitive also.
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "configuration")
public class Configuration {

	private DatabaseConfiguration databaseConfiguration;

	private String logConfigurationFilePath;

	private Configuration() {

	}

	public DatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public String getLogConfigurationFilePath() {
		return logConfigurationFilePath;
	}

	@Override
	public String toString() {
		return "Configuration [databaseConfiguration=" + databaseConfiguration + ", logConfigurationFilePath="
				+ logConfigurationFilePath + "]";
	}

}