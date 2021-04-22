package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

	@Test(priority = 1)
	public void homeTitleTest() {
		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	@Test(priority = 2)
	public void homeHeaderTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text() ='My Account']")).isDisplayed());
	}

	@Test(priority = 3)
	public void homeSearchTest() {
		driver.findElement(By.xpath("//input[@name = 'search']")).sendKeys("imac");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	}

}
