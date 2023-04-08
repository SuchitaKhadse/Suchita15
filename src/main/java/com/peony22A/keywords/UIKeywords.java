package com.peony22A.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class UIKeywords {
	public static RemoteWebDriver driver;
	public static FluentWait<WebDriver> wait;


	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("internetexplorer")) {
			driver = new InternetExplorerDriver();

		}
		wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));

		System.out.println(browserName + "Browser launch Successfull");
	}
	

	public static void launchURl(String url) {
		driver.get(url);

	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed Successfully");
	}

	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {
				System.out.println("switch to window" + byTitle);
				break;
			}
		}
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> textsList = new ArrayList<String>();
		for (WebElement elemt : elements) {
			textsList.add(elemt.getText());
			}
		return textsList;

		}
		public static void enterText(By element, String text) {
			driver.findElement(element).sendKeys(text);
		}

		public static void hitutton(int keyCode) {
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {

			}
			robot.keyPress(keyCode);

		}

		public static void mouseMove(By cssSelector) {
			Actions act =new Actions(driver);
			act.moveToElement(driver.findElement(cssSelector)).build().perform();
			
		}

		public static void clickOn(By cssSelector) {
		driver.findElement(cssSelector).click();
			
		}


		public static void scrollBy(Object executeScript) {
			driver.executeScript("window.scrollBy(0,300)");
			
		}



}
