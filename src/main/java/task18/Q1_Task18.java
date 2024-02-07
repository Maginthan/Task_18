package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q1_Task18 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch the Chrome browser
		WebDriver driver = new FirefoxDriver();

		// Load the URL using get method
		driver.get("https://www.facebook.com/");

		// Implicit wait for the element of the page to click them
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Maximise the browser view
		driver.manage().window().maximize();

		// Click accept all cookies
		driver.findElement(By.xpath("//button[text()='Allow all cookies']")).click();

		// Finding an element using text X-path to click Create account button
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		// Fill all the mandatory fields inside the Sign-up form
		driver.findElement(By.name("firstname")).sendKeys("Jagaendran");
		driver.findElement(By.name("lastname")).sendKeys("vasu");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Jagaendran98@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("Jagaendran98@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Newpasword@034");

		// Locate the select tag for Day, Month and Year
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		// Select inputs from Drop-down using select class
		Select select = new Select(day);
		Select select2 = new Select(month);
		Select select3 = new Select(year);
		select.selectByValue("3");
		select2.selectByValue("12");
		select3.selectByValue("1997");

		// Select radio button using Xpath
		driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();

		// Click the Sign-Up button
		driver.findElement(By.name("websubmit")).click();

		// Validate the page is navigated to Email verification screen
		String verifyText = driver.findElement(By.xpath("(//h2[text()='Enter the code from your email'])[2]"))
				.getText();

		if (verifyText.equals("Enter the code from your email")) {
			System.out.println("The page is navigated to Email verification screen successfully");
		} else {
			System.out.println("The page navigation to Email verification screen failed");
		}

	}

}
