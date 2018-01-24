package jsample.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "databaseConfiguration")
public class DatabaseConfiguration {

	private String databaseServerAddress;
	private String databasePort;
	private String databaseName;
	private String databaseUserName;
	private String databasePassword;

	private DatabaseConfiguration() {

	}

	public String getDatabaseServerAddress() {
		return databaseServerAddress;
	}

	public String getDatabasePort() {
		return databasePort;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getDatabaseUserName() {
		return databaseUserName;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	@Override
	public String toString() {
		return "DatabaseConfiguration [databaseServerAddress=" + databaseServerAddress + ", databasePort="
				+ databasePort + ", databaseName=" + databaseName + ", databaseUserName=" + databaseUserName
				+ ", databasePassword=" + databasePassword + "]";
	}
}