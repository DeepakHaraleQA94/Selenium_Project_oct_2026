package TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssert {

	
	@Test(enabled = false)
	 public void TC1() 
	 
	 {
	 String ExpectedResult="abc1";
	 String ActualResult="abc";
	 
	 Assert.assertEquals(ActualResult, ExpectedResult,"Result is not matching");
	 Reporter.log("TC1 is running", true);
	 }

	@Test(enabled = false)
	 public void TC2() 
	 
	 {
	 String ExpectedResult="abc1";
	 String ActualResult="abc";
	 Assert.assertNotEquals(ActualResult, ExpectedResult, "Result is matching");
	 Reporter.log("TC2 is running", true);
	 }
	
	 @Test(enabled = false)
	 public void TC3() 
	 
	 {
	//boolean output= Title.isSelected();
	//boolean output= Title.isEnabled();
	//boolean output= Title.isMultiple();
	 //boolean output= Title.isDisplayed();
	 boolean Result=true;
	 
	 Assert.assertTrue(Result, "Result is false");
	 Reporter.log("TC3 is running", true);
	 }

	
	
	
	 @Test(enabled = false)
	 public void TC4() 
	 
	 {
	 //boolean output= Title.isDisplayed();
	 boolean Result=true;
	 
	 Assert.assertFalse(Result,"Result is true");
	 Reporter.log("TC4 is running", true);
	 }

	 
	 @Test(enabled = false)
	 public void TC5() 
	 
	 {
	String str=null;
	Assert.assertNull(str,"Value is not null");
	Reporter.log("TC5 is running", true);
	 }

	 @Test (enabled = false)
	 public void TC6() 
	 
	 {
	String str= null;
	Assert.assertNotNull(str,"Value is null");
	Reporter.log("TC6 is running", true);
	 }

	 
	 @Test
	 public void TC7() 
	 
	 {
	Reporter.log("Assert fail check", true);

	Reporter.log("TC7 is running", true);
	 }

	
}
