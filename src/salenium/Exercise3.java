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

public class Exercise3 {
	WebDriver driver;

	@BeforeClass
	void initClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/ravi/Downloads/automation/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@AfterClass
	void distroyClass() {

	}

	@BeforeMethod
	void initMethod() {

	}

	@AfterMethod
	void distoryMethod() {

	}

	@Test
	void printLine() {
		WebElement e = driver.findElement(By.id("lst-ib"));
		e.sendKeys("2+2");
		e.submit();
		
		WebElement result = driver.findElement(By.id("cwos"));
		String s =result.getText();
		
		Assert.assertEquals(s, "4");
	}
}