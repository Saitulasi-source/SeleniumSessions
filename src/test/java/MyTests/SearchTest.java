package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	@Test(priority = 2)
	public void searchTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Search - imac");
	}

	@Test(priority = 1)
	public void searchImacLinkTest() {
		driver.get("https://demo.opencart.com/index.php?route=product/search&search=imac");
		Assert.assertTrue(driver.findElement(By.linkText("iMac")).isDisplayed());
	}

}
