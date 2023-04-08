package com.peony22A;

import org.testng.annotations.Test;

import com.peony22A.config.TestBase;
import com.peony22A.keywords.UIKeywords;
import com.peony22A.util.Environment;

public class MensTshirtTests extends TestBase {
	UIKeywords keywords = new UIKeywords();

	@Test
	public void verifySearchFieldByPolpularityWithProperResult() {
		Environment env  =new Environment();
		UIKeywords.launchURl(env.getUrl());
	

	}
}
