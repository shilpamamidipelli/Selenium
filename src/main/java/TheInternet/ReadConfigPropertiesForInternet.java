package TheInternet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigPropertiesForInternet {
	private Properties config;
	// https://the-internet.herokuapp.com
	// https://testpages.eviltester.com/styled/index.html
	// https://selectorshub.com/xpath-practice-page/
	// https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/

    public ReadConfigPropertiesForInternet() {
        config = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("config properties file not found in classpath");
                throw new RuntimeException("config properties file not found in classpath");
            }
            System.out.println("config properties file found and being loaded");
            config.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load config properties", ex);
        }
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
