package com.peony22A.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.peony22A.keywords.UIKeywords;


public class TestBase {
	@Parameters("browserName")
	@BeforeMethod

	public static void setUp(@Optional String browserName) throws Exception {

		if (browserName == null) {
			browserName = "Chrome";

		}
		if (browserName.isEmpty()) {
			browserName = "Chrome";
			System.out.println("default browser is Chrome");
		}
		UIKeywords.openBrowser(browserName);
	}

	@AfterMethod
	public static void tearDown() throws Exception {
		UIKeywords.closeBrowser();

	}
}
