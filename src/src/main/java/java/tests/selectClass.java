package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		
		WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
		Select s = new Select(dropdown);
		Thread.sleep(2000);
		s.selectByIndex(2);
		driver.quit();
		
		
	}

}
