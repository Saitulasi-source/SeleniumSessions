package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(priority = 2)
	public void loginTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}

	@Test(priority = 1)
	public void loginURLTest() {
		Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));
	}

	@Test(priority = 3)
	public void loginLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Your Store")).isDisplayed());
	}

	@Test(priority = 4)
	public void loginTest() {
		driver.findElement(By.id("input-email")).sendKeys("saitulasi@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

}

