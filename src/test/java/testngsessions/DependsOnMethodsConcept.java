package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	@Test
	public void loginTest() {
		System.out.println("login test");
		//int i = 9 / 0;
	}

	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home test");
	}

	@Test(dependsOnMethods = "homeTest")
	public void profileTest() {
		// logo
		// name
		// account info
		// email
		// reset pwd
	}

	@Test(dependsOnMethods = "loginTest")
	public void searchTest() {
		System.out.println("Search test");
	}
}
