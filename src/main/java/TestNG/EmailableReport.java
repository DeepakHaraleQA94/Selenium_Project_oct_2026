package TestNG;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class EmailableReport {

	@Test
	public void Test() {
		
		Reporter.log("Hello TestNG",true);
	}
	
	@Test
	public void Test1() {
		
		Reporter.log("Hello Java",true);
	}
}
