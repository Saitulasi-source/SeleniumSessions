package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysAndClickConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
//		WebElement emailEle = driver.findElement(By.name("email"));
//		WebElement passwordEle = driver.findElement(By.name("password"));
//		WebElement loginEle = driver.findElement(By.xpath("//input[@type = 'submit' and @value = 'Login']"));
		By email = By.name("email");
		By password = By.name("password");
		By login = By.xpath("//input[@type = 'submit' and @value = 'Login']");
		doActionsSendKeys(email, "saitulasi04@gmail.com");
		doActionsSendKeys(password, "test@123");
		doActionsClick(login);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	public static void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

}
