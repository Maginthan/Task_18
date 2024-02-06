package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q2_Task18 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch the Chrome browser
		WebDriver driver = new ChromeDriver();

		// Load the URL using get method
		driver.get("https://jqueryui.com/droppable/");

		// Implicit wait for the element of the page to click them
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Maximise the browser view
		driver.manage().window().maximize();

		// Switch to frame using index
		driver.switchTo().frame(0);

		// Create web elements of source and destination to perform Drag and Drop
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));

		// Target element text and color before drag and drop action
		String preText = destination.getText();
		String preColor = destination.getCssValue("background-color");

		// Using Action class to perform Drag and Drop operation
		Actions mouse = new Actions(driver);
		mouse.dragAndDrop(source, destination).perform();

		// Thread sleep to get the aftrText and aftrColor
		Thread.sleep(2000);

		// Target element text and color after drag and drop action
		String aftrText = destination.getText();
		String aftrColor = destination.getCssValue("background-color");

		// Validating the target element color and text
		if (aftrText.equals("Dropped!") && aftrColor.equals("rgba(255, 250, 144, 1)")) {
			System.out.println("The Drag and Drop was successful");
			System.out.println("The text has been changed to " + aftrText
					+ " and the background color of the elemnent is changed to " + aftrColor);
		} else {
			System.out.println("The Drag and Drop was unsuccessful");
		}

	}

}
