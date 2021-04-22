package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	@BeforeSuite
	public void createUserInDB() {
		System.out.println("BS - Create User In DB");
	}

	@BeforeTest
	public void giveUserPermission() {
		System.out.println("BT - Give User Permission");
	}

	@BeforeClass
	public void launchApp() {
		System.out.println("BC - Open the browser and launch app");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM - Login");
	}

	@Test
	public void appLogoTest() {
		System.out.println("App Logo Test");
	}

	@Test
	public void SearchProductTest() {
		System.out.println("Search Product Test");
	}

	@Test
	public void AddToCartTest() {
		System.out.println("Add To Cart Test");
	}

	@Test
	public void paymentTest() {
		System.out.println("Payment Test");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM - Logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - Close Browser");
	}

	@AfterTest
	public void deleteTheUser() {
		System.out.println("AT - Delete The User");
	}

	@AfterSuite
	public void closeDBConnection() {
		System.out.println("AS - Close DB Connection");
	}
}
