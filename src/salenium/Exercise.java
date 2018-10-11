package salenium;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise {

	public static void main(String[] args) {

	}

	@DataProvider(name = "valid-data")
	Object[][] validData() {
		return new Object[][] { { "1234" }, { "-23456" } };
	}

//	@DataProvider(name = "invalid-data")
//	Object[][] inValidData() {
//		return new Object[][] { 
//			{ "abc" }, 
//			{ "-" }, 
//			{ "" }, 
//			{ null }, 
//			{ "21474836479" } };
//	}

	@Test(dataProvider = "valid-data")
	void positiveTest(String input) {
		Assert.assertTrue(isNumeric(input));
	}

	@Test(dataProvider = "invalid-data")
	void negativeTest(String input) {
		Assert.assertFalse(isNumeric(input));
	}

	boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}