package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions action = new Actions(driver);
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text() = 'right click me']"));
		action.contextClick(rightClickEle).perform();
		By rightClickOption = By.xpath("//ul[@class = 'context-menu-list context-menu-root']/li/span");
//		List<WebElement> optionsList = driver
//				.findElements(By.xpath("//ul[@class = 'context-menu-list context-menu-root']/li/span"));
//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}
		selectRightClickOption(rightClickOption, "Copy");

	}

	public static void selectRightClickOption(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
