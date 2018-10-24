package home;

import java.util.Set;

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

public class Footer {

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
		driver.quit();
	}

	@AfterClass
	void resetClass() {
		System.clearProperty("webdriver.chrome.driver");
	}

	@Test
	void aboutUs() {
		WebElement element = driver.findElement(By.linkText("About Us"));
		element.click();

		String tab = driver.getWindowHandle();
		WebDriver window = driver.switchTo().window(tab);

		Assert.assertEquals(window.getCurrentUrl(), "https://www.cashify.in/about-us");
	}

	@Test
	void career() {
		WebElement element = driver.findElement(By.linkText("Careers"));
		element.click();

		String tab = driver.getWindowHandle();
		WebDriver window = driver.switchTo().window(tab);

		Assert.assertEquals(window.getCurrentUrl(), "https://www.cashify.in/career");
	}

	@Test
	void blog() {
		WebElement element = driver.findElement(By.linkText("Blog"));
		element.click();

		Set<String> tabs = driver.getWindowHandles();

		boolean isBlogFound = false;
		for (String tab : tabs) {
			WebDriver w = driver.switchTo().window(tab);

			if (w.getCurrentUrl().equals("https://www.cashify.in/blog/")) {
				isBlogFound = true;
				break;
			}
		}

		Assert.assertTrue(isBlogFound);
	}

	@Test
	void faq() {
		WebElement e = driver.findElement(By.linkText("FAQ"));
		e.click();

		Set<String> tabs = driver.getWindowHandles();
		boolean isFound = false;
		for (String tab : tabs) {
			WebDriver w = driver.switchTo().window(tab);
			if (w.getCurrentUrl().equals("https://www.cashify.in/blog/faqs/buyback/")) {
				isFound = true;
			}

		}
		Assert.assertTrue(isFound);
	}
}