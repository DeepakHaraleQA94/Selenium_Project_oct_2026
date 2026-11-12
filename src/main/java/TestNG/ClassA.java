package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassA {

	@Test(groups = "Sanity")
	public void A() {
		System.out.println("A");
	}
	
	@Test(groups = "smoke")
	public void B() {
		
		System.out.println("B");
	}
	
	@Test(groups = "functional")
	public void C() {
		System.out.println("C");
	}
	
	@Test(groups="smoke")
	public void D() {
		Assert.fail();
		System.out.println("D");
	}
}
