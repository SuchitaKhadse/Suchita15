package com.peonny22A.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.peony22A.keywords.UIKeywords;

public class MenTshirtPage {
	public WebElement sortByFilter;
	public WebElement countryOfOrigin;
	public WebElement size;

	public MenTshirtPage() {
		sortByFilter = UIKeywords.driver.findElement(By.cssSelector("div.sort-sortBy"));
		countryOfOrigin = UIKeywords.driver.findElement(By.cssSelector(
				" #desktopSearchResults > div:nth-child(1) > section > div:nth-child(1) > div.atsa-base > ul > li:nth-child(2) > label > h4"));
		size = UIKeywords.driver.findElement(By.cssSelector(""));
	}
}
