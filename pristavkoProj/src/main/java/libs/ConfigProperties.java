package libs;

import org.aeonbits.owner.Config;

public interface ConfigProperties extends Config {
	long TIME_FOR_DFFAULT_WAIT();

	String base_url();
	String user_login();
	String user_password();
	String wrong_user_password();
	String DATA_FILE();
	String DATA_FILE_SUITE();
	String Oracle();
	String MySQL();
	String sqlServer();
	String MySQL_DB();
	String MySQL_DB_USER();
	String MySQL_DB_PASSWORD();

}
