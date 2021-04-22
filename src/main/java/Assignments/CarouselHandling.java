package Assignments;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandling {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");

		getCarouselList("Recommended For You");

	}

	public static Set<String> getCarouselList(String deptName) {

		String xpath = "//h3[text()='" + deptName
				+ "']/parent::div/../following-sibling::div//div[@data-qa='product-name']";
		List<WebElement> deptList = driver.findElements(By.xpath(xpath));
		System.out.println(deptList.size());
		String next_xpath = "//h3[text()='" + deptName
				+ "']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]";
		By nextEleXpath = By.xpath(next_xpath);
		Set<String> dataSet = new TreeSet<String>();
		while (!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("swiper-button-disabled")) {

			for (WebElement e : deptList) {
				String text = e.getText();
				if (!text.isEmpty()) {
					dataSet.add(text);
				}
			}
			doMoveToElementAndclickElement(nextEleXpath);
			// clickElementByJS(getElement(nextEleXpath));
			// driver.findElement(By.xpath(next_xpath)).click();
		}
		dataSet.stream().forEach(e -> System.out.println(e));
		return dataSet;
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
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
