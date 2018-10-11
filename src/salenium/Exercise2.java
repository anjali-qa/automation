package salenium;

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

public class Exercise2 {

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

	@Test
	void checkSignIn() {

		driver.get("https://www.google.com/");
		driver.findElement(By.linkText("Sign in")).click();

		Set<String> tabs = driver.getWindowHandles();

		for (String tab : tabs) {
			WebDriver window = driver.switchTo().window(tab);
			if (window.getTitle().equals("Sign in - Google Accounts")) {
				break;
			}
		}

		WebElement userIdElem = driver.findElement(By.id("identifierId"));
		userIdElem.sendKeys("ravi.k@cashify.in");
		driver.findElement(By.id("identifierNext")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));

		WebElement passIdElem = driver.findElement(By.name("password"));
		passIdElem.sendKeys("reglobe@123");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));

		driver.findElement(By.id("passwordNext")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='gb_9a gbii']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).isDisplayed());
	}
	
	@AfterClass
	void resetClass() {
		System.clearProperty("webdriver.chrome.driver");
	}
}