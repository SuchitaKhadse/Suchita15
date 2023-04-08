package com.peonny22A.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.peony22A.keywords.UIKeywords;

public class HomePage {
	public WebElement menmenuElement;

	public HomePage() {
		menmenuElement = UIKeywords.driver.findElement(By.cssSelector("a[style=\"border-bottom-color:#ee5f73;\"]"));
	}
	public void hoverOnMenMenu() {
		Actions actions=new Actions(driver);
		

	}
}
