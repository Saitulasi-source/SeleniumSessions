package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDateHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		By calendar = By.cssSelector("table.ui-datepicker-calendar a");
		// selectDate("1");
		// selectDate(calendar, "8");
		// selectFutureDate("19", "August", "2021");
		selectPreviousDate("20", "June", "2018");

	}

	public static void selectDate(String day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

	public static void selectDate(String htmlTag, String day) {
		driver.findElement(By.xpath("//" + htmlTag + "[text()='" + day + "']")).click();
	}

	public static void selectDate(By locator, String day) {

		List<WebElement> daysList = driver.findElements(locator);
		System.out.println(daysList.size());
		for (WebElement e : daysList) {
			String text = e.getText();
			if (text.equals(day)) {
				e.click();
				break;
			}

		}
	}

	public static String[] getMonthYear(String monthYear) {
		return monthYear.split(" ");
	}

	public static void selectFutureDate(String exday, String exmonth, String exyear) {

		if (exmonth.equals("February") && Integer.parseInt(exday) > 29) {
			System.out.println("Wrong date : " + exmonth + " : " + exday);
			return;
		}
		String monthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		while (!(getMonthYear(monthYear)[0].equals(exmonth) && getMonthYear(monthYear)[1].equals(exyear))) {
			System.out.println(monthYear);
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}
		selectDate(exday);
	}

	public static void selectPreviousDate(String exday, String exmonth, String exyear) {

		if (exmonth.equals("February") && Integer.parseInt(exday) > 29) {
			System.out.println("Wrong date : " + exmonth + " : " + exday);
			return;
		}
		String monthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		while (!(getMonthYear(monthYear)[0].equals(exmonth) && getMonthYear(monthYear)[1].equals(exyear))) {
			System.out.println(monthYear);
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			monthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		}
		selectDate(exday);
	}
}