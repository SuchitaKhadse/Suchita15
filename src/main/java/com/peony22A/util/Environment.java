package com.peony22A.util;

public class Environment {
	String filepath = "/src/main/resources/Environment.properties";

public String getUrl() {
	PropUtil prop= new PropUtil();
	String baseDir =System.getProperty("user.dir");
return prop.getValue( baseDir+filepath,"app_url");
}
}