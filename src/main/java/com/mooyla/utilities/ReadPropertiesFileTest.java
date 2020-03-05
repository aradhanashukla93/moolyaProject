package com.mooyla.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFileTest {
		   
	/**
	 * Method to read properties file to read data for the test-cases
	 * @param fileName
	 * @return properties file object
	 * @throws IOException
	 */
	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}
}