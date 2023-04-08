package com.peony22A.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import com.peony22A.keywords.UIKeywords;

public class WaitFor {
	public static Object elementToBePresent;
	static FluentWait<WebDriver> wait = null;
	static{
		wait=new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(600));
		wait.withMessage("wait os over and element is not visible");
	}

	public  static void elementToBePresent(By locator) {
		wait.ignoring(NoSuchElementException.class);
wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
