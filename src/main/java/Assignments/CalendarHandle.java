package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		SelectCalendarDate("28", "September", "2021");

	}

	public static void SelectCalendarDate(String exDay, String exMonth, String exYear) {
		String month = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[1]")).getText();
		String year = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[2]")).getText();
		while (!(month.equals(exMonth) && year.equals(exYear))) {
			driver.findElement(By.cssSelector("a.ui-datepicker-next.ui-corner-all span")).click();
			month = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[1]")).getText();
			year = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[2]")).getText();
		}
		selectDate(exDay, "a");
	}

	public static void selectDate(String day, String htmlTag) {
		driver.findElement(By.xpath("//" + htmlTag + "[text()='" + day + "']")).click();
	}

	public static void selectDate(By locator, String day) {
		List<WebElement> daysList = driver.findElements(locator);

		System.out.println(daysList.size());

		for (WebElement e : daysList) {
			if (e.getText().equals(day)) {
				e.click();
				break;
			}
		}

	}

}
