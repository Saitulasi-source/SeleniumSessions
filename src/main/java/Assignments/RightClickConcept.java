package Assignments;

import java.util.List;

import org.openqa.selenium.Alert;
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
		By rightClick = By.xpath("//span[text() = 'right click me']");
		By rightClickOption = By.xpath("//ul[@class = 'context-menu-list context-menu-root']/li/span");
		doRightClick(rightClick);
		selectRightClickOption(rightClickOption, "Edit");
		String editAlertText = getAlertText();
		System.out.println("Edit Alert Text : " + editAlertText);
		doRightClick(rightClick);
		selectRightClickOption(rightClickOption, "Cut");
		String cutAlertText = getAlertText();
		System.out.println("Cut Alert Text : " + cutAlertText);
		doRightClick(rightClick);
		selectRightClickOption(rightClickOption, "Copy");
		String copyAlertText = getAlertText();
		System.out.println("Copy Alert Text : " + copyAlertText);
		doRightClick(rightClick);
		selectRightClickOption(rightClickOption, "Paste");
		String pasteAlertText = getAlertText();
		System.out.println("Paste Alert Text : " + pasteAlertText);
		doRightClick(rightClick);
		selectRightClickOption(rightClickOption, "Delete");
		String deleteAlertText = getAlertText();
		System.out.println("Delete Alert Text : " + deleteAlertText);
		doRightClick(rightClick);
		selectRightClickOption(rightClickOption, "Quit");
		String quitAlertText = getAlertText();
		System.out.println("Quit Alert Text : " + quitAlertText);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
	}

	public static void doRightClick(By locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElement(locator)).perform();

	}

	public static void selectRightClickOption(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
