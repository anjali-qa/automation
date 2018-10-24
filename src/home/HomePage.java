package home;

import java.util.List;
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
		driver.get("https://www.cashify.in/");
	}

	@AfterMethod
	void resetMethod() {
//		driver.quit();
	}

	@AfterClass
	void resetClass() {
		System.clearProperty("webdriver.chrome.driver");
	}

	@Test
	void test2() {

		WebElement ele = driver.findElement(By.linkText("LOGIN"));
		ele.click();

		WebElement mol = driver.findElement(By.id("mobile-number"));
		mol.sendKeys("8448381775");

		WebElement ver = driver.findElement(By.xpath("//button[@type='submit']"));
		ver.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter OTP']")));

		WebElement otp = driver.findElement(By.xpath("//input[@placeholder='Enter OTP']"));
		otp.sendKeys("181024");

		WebElement otpSubmit = driver.findElement(By.xpath("//button[contains(text(),'submit')]"));
		otpSubmit.click();

	}
}