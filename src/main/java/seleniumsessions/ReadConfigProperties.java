package seleniumsessions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {

	// https://the-internet.herokuapp.com
	// https://testpages.eviltester.com/styled/index.html
	// https://selectorshub.com/xpath-practice-page/
	// https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/

	public static String readProp(String propName) throws IOException {

		Properties properties ;
		String configFileName = "config.properties";
		String siteToTest = propName;
		String URL = null;
		File configFile = new File(configFileName);

		try {

			FileInputStream fip = new FileInputStream(configFile);
			properties = new Properties();
			try {
				properties.load(fip);
				URL = properties.getProperty(siteToTest);
				fip.close();
				return URL;
			}catch (IOException e) {
				System.out.println("Error reading file or file doesn't exist");
			}
		} catch (FileNotFoundException f) {
			throw new RuntimeException("config properties file not found at the path" + configFileName);
		} 


		return URL;
	}

}