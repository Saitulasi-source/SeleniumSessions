package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		By mainMenu = By.className("menulink");
		doMoveToElement(mainMenu);
		Thread.sleep(2000);
		By articles = By.linkText("ARTICLES");
		By courses = By.linkText("COURSES");
		By videos = By.linkText("SINGLE VIDEOS");
		doMoveToElementAndclickElement(articles);
//		clickElement(courses);
//		clickElement(videos);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doMoveToElement(By locator) {

		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).perform();
	}

	public static void doMoveToElementAndclickElement(By locator) {
		doMoveToElement(locator);
		getElement(locator).click();
	}

}
