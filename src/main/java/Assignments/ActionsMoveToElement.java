package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsMoveToElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com");
		Thread.sleep(2000);
		By mainMenu = By.linkText("LOGIN / SIGNUP");
		By subMenu = By.linkText("SpiceClub Members");
		By subSubMenu = By.linkText("Member Login");
		By subSubMenuSignup = By.linkText("Sign up");
		doMoveToElement(mainMenu, subMenu);
		Thread.sleep(2000);
		doMoveToElementandClick(subSubMenu);
		// doMoveToElementandClick(subSubMenuSignup);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doMoveToElement(By locator1, By locator2) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator1)).perform();
		action.moveToElement(getElement(locator2)).perform();
	}

	public static void doMoveToElementandClick(By locator) {
		doMoveToElement(locator, locator);
		getElement(locator).click();
	}

}
