package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table1 {

	
	public static void main (String args[]) {
		
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement>  rows = driver.findElements(By.xpath("//table[@id='customers']//tr[position()>3]"));
		
		for (WebElement row: rows) {
			String country = row.findElement(By.xpath("./td[3]")).getText();
			
			if(country.equals("UK")) {
				System.out.print(row.getText());
				
			}
			
			
			
			
		}
		
		
		
	}
}
