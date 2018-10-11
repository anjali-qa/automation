package salenium;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise4 {

	@DataProvider(name="datas")
	Object[][] sendData() { 
		return new Object[][] { {"123"},{"-432"},{"0"},{"-0"}};
	}

	@Test(dataProvider = "datas")
	void test(String input) {
		boolean val = isNumeric(input);
		Assert.assertTrue(val);
	}

	boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}