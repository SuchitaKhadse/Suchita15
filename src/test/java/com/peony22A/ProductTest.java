package com.peony22A;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.StaticInitializerCoercer;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.peony22A.config.TestBase;
import com.peony22A.keywords.UIKeywords;
import com.peony22A.util.Environment;
import com.peony22A.util.PropUtil;
import com.peony22A.util.WaitFor;

public class ProductTest extends TestBase {
	@Test
	public static void verifySearchResultForPoloForMen() throws AWTException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com");
		driver.findElement(By.cssSelector("input[placeholder='Search for products, brands and more']"))
				.sendKeys("polo men");
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		List<WebElement> elmements = driver.findElements(By.cssSelector("h4.product-product"));

		for (WebElement element : elmements) {
			String title1 = element.getText();

			Assert.assertTrue(title1.contains("polo men"), "title doesnt contais polo" + title1);

		}
	}

	/* UsingKeyword */
	@Test
	public static void verifySearchResultForPoloMen() {
		UIKeywords.launchURl("https://www.myntra.com");
		UIKeywords.enterText(By.cssSelector("input[placeholder='Search for products, brands and more']"), "polo men");
		UIKeywords.hitutton(KeyEvent.VK_ENTER);
		List<String> productTittles = UIKeywords.getTexts(By.cssSelector("h4.product-product"));
		for (String productTitle : productTittles) {
			Assert.assertTrue(productTitle.contains("polo "), "Product tittle doent conytains polo" + productTitle);

		}
	}

	/* Using Object Repository */
	// using properties file and Interface
	// 1-Properties file ,locater place in property file->main/resources
	@Test
	public void verifySearchResultForPoloMenUsingOR() {
		Environment env = new Environment();
		UIKeywords.launchURl(env.getUrl());
		PropUtil repo = new PropUtil();
		UIKeywords.enterText(By.cssSelector(repo.getLocator("search_Products_txtBox")), "polo men");
		UIKeywords.hitutton(KeyEvent.VK_ENTER);
		List<String> productTittles = UIKeywords.getTexts(By.cssSelector(repo.getLocator("product_tittles_txt")));
		for (String productTitle : productTittles) {
			Assert.assertTrue(productTitle.contains("polo  "), "Product tittle doent conytains polo" + productTitle);

		}
	}

	@Test
	public static void verifyCategeriesForTopWear() {
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Tshirts");
		expectedList.add("Shirts");
		expectedList.add("Sweatshirts");
		expectedList.add("Kurtas");
		expectedList.add("Jackets");
		expectedList.add("Sweaters");
		expectedList.add("Blazers");

		Environment env = new Environment();

		UIKeywords.launchURl(env.getUrl());
		PropUtil repo = new PropUtil();
		WaitFor.elementToBePresent(By.cssSelector(repo.getLocator("men_menu")));
		UIKeywords.mouseMove(By.cssSelector(repo.getLocator("men_menu")));
		UIKeywords.clickOn(By.cssSelector(repo.getLocator("men_menu_topWear")));
	//	WaitFor.elementToBePresent(By.cssSelector(repo.getLocator("categeries_text")));
		List<String> actualCategoriesList = UIKeywords.getTexts(By.cssSelector(repo.getLocator("categeries_text")));
		Assert.assertTrue(actualCategoriesList.containsAll(expectedList));
	}
	@Test
public static void verifySearchResultForWatchUnder999(){
	Environment env = new Environment();

	UIKeywords.launchURl(env.getUrl());
UIKeywords.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
UIKeywords.scrollBy(UIKeywords.driver.executeScript("window.scrollBy(0,300)"));
UIKeywords.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
}
