package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcases {
	
	SoftAssert softAssert=new SoftAssert();
	
	@Test
	public void test1() {
		System.out.println("Open Browser");
		
		Assert.assertEquals(true, true);
		
		System.out.println("Enter Username");
		System.out.println("Enter Password");
		System.out.println("Click on signin button");
		
		Assert.assertEquals(true, true);
		
		System.out.println("Validate Home Page");
		
		softAssert.assertEquals(true, false, "Home Page titlte is missing");
		
		
		System.out.println("Go to deals page");
		System.out.println("Create a deal");
		
		softAssert.assertEquals(true, false);

		System.out.println("Go to contacts");
		System.out.println("Create a contact");
		
		softAssert.assertEquals(true, false);
		
		softAssert.assertAll();
			
		
	}
	
	
	

}
