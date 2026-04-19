package tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table3 {
	
	public static void main (String args[]) {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.switchTo().frame("FrameName");
		driver.switchTo().defaultContent();
		Set<String> windows = driver.getWindowHandles();
		for(String win : windows) {
			driver.switchTo().window(win);}
		
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.accept();
		alert.getText();
		alert.sendKeys("abc");
		
		
			
		
		//WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
		
		/*List<WebElement> rows = driver.findElements(By.xpath("//tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = driver.findElements(By.xpath(".//th | .//td "));
			
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				
			}
		}
		
		
		System.out.println();*/
		
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int cols = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		
		System.out.println("Rows: " + rows);
		System.out.println("Columns: " + cols);
		
		
	}

}
