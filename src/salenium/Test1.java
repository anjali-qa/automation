package salenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

	@BeforeClass
	void initClass() {
		System.out.println("@BeforeClass");
	}

	@BeforeMethod
	void initMethod() {
		System.out.println("@BeforeMethod");
	}
	
	@Test
	void testAbc() {
		System.out.println("testAbc");
	}
	
	@Test
	void testAbc2() {
		System.out.println("testAbc2");
	}
	
	@Test
	void testAbc3() {
		System.out.println("testAbc3");
	}
	
	@AfterMethod
	void desMethod() {
		System.out.println("@AfterMethod");
	}
	
	@AfterClass
	void destroyClass() {
		System.out.println("@AfterClass");
	}
}
