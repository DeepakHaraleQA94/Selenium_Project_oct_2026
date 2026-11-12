package SeleniumBasic;

import net.bytebuddy.utility.RandomString;

public class Demo {

	public static void main(String[] args) {
		  String random = RandomString.make(3);
		  System.out.println(random);
		  String Projectpath = System.getProperty("user.dir");
		  System.out.println(Projectpath);
	}
}
