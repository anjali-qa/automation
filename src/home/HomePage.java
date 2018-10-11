package home;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {

	WebDriver driver;

	@BeforeClass
	void setupClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/ravi/Downloads/automation/chromedriver");
	}

	@BeforeMethod
	void setupMethod() {
		driver = new ChromeDriver();
	}

	@AfterMethod
	void resetMethod() {
		driver.quit();
	}
	
	@AfterClass
	void resetClass() {
		System.clearProperty("webdriver.chrome.driver");
	}
}