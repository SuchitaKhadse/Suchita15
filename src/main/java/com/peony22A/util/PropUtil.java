package com.peony22A.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public String getValue(String filePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("file not found" + filePath);
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to load file" + filePath);
		}
		return prop.getProperty(key);
	}

	/**
	 * This method can be use on OR.properties file only. key for which we want
	 * locator.
	 * 
	 * @return
	 * 
	 */
	public String getLocator(String key) {
		String baseDir = System.getProperty("user.dir");
		return getValue(baseDir + "/src/main/resources/OR.properties", key);
	}
}
