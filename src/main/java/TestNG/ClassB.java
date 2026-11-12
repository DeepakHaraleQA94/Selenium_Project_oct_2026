package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassB {

	@Test(groups = "smoke")
	public void E() {
		Assert.fail();
		System.out.println("E");
	}
	
	@Test(groups = "Sanity")
	public void F() {
		System.out.println("F");
	}
	
	@Test(groups = "smoke")
	public void G() {
		
		System.out.println("G");
	}
	
	@Test(groups = "functional")
	public void H() {
		System.out.println("H");
	}
	
}
