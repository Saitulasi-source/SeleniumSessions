package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name;

	@Test(expectedExceptions = { ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("login test");
		int i = 9 / 0;
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj = null;
		obj.name = "loginTest";
		System.out.println(obj.name);
		}

}
