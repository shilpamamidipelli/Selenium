package TheInternet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigPropertiesForInternet {

	// https://the-internet.herokuapp.com
	// https://testpages.eviltester.com/styled/index.html
	// https://selectorshub.com/xpath-practice-page/
	// https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/

	
	public static String getProp(String propName) throws IOException {
		 Properties properties = new Properties();
		String configFileName = "config.properties";
		String siteToTest = propName;
		String URL = null;
		File configFile = new File(configFileName);

		try {

			FileInputStream fip = new FileInputStream(configFile);

			try {
				properties.load(fip);
				URL = properties.getProperty(siteToTest);
				fip.close();
				return URL;
			} catch (IOException e) {
				System.out.println("Error reading file or file doesn't exist");
			}
		} catch (FileNotFoundException f) {
			throw new RuntimeException("config properties file not found at the path " + configFileName);
		}

		return URL;
	}
}
