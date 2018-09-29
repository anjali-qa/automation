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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebDriverDemo {

//	public static void main(String[] args) {
//
//		System.setProperty("webdriver.gecko.driver", "/Users/ravi/Downloads/automation/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/ravi/Downloads/automation/chromedriver");
//
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		
//		driver.manage().window().maximize();
//		
//		WebElement element = driver.findElement(By.id("lst-ib"));
//		element.sendKeys("Anjali's Facebook profile");
//		element.submit();
////		driver.quit();
//	}

	WebDriver driver;

	@BeforeClass
	void classSetup() {
//		System.setProperty("webdriver.gecko.driver", "/Users/ravi/Downloads/automation/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/ravi/Downloads/automation/chromedriver");
	}

	@AfterClass
	void destoyClass() {
//		System.clearProperty("webdriver.gecko.driver");
		System.clearProperty("webdriver.chrome.driver");
	}

	@BeforeMethod
	void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
//		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "calc-data")
	Object[][] provideData() {
		return new Object[][] { { "2+3", "5" }, { "sqrt 4", "2" }, { "3-2", "1" } };
	}

	@Test(dataProvider = "calc-data")
	void demoTest(String input, String output) {

		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys(input);
		element.submit();

		WebElement result = driver.findElement(By.id("cwos"));

		Assert.assertEquals(result.getText(), output);
	}

//	@Test
//	void demoTest2() {
//
//		WebElement element = driver.findElement(By.id("lst-ib"));
//		element.sendKeys("sqrt 16");
//		element.submit();
//
//		WebElement result = driver.findElement(By.id("cwos"));
//
//		Assert.assertEquals(result.getText(), "4");
//	}
}
