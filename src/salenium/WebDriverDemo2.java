package salenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverDemo2 {
	
	WebDriver driver;

	@BeforeClass
	void init() {
		System.setProperty("webdriver.chrome.driver", "/Users/ravi/Downloads/automation/chromedriver");
	}
	
	@AfterClass
	void reset() {
		System.clearProperty("webdriver.chrome.driver");
	}
	
	@BeforeMethod
	void initMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@AfterMethod
	void resetMethod() {
		driver.quit();
	}
	
	
	@Test
	void test1() {
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("2+3");
		element.submit();

		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), "5");
	}
	
	
	@Test
	void test2() {
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("sqrt 16");
		element.submit();

		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), "4");
	}
}
