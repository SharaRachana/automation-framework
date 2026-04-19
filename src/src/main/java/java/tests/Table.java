package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
    public static void main(String[] args) {
    	
    	WebDriver driver= new ChromeDriver();
    	driver.get("https://www.w3schools.com/html/html_tables.asp");
    	WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
    	
    	
    	List<WebElement> rows = table.findElements(By.xpath(".//tr"));
    	
    	
    	for (WebElement row : rows) {
    		List<WebElement> cells = row.findElements(By.xpath(".//th | .//td "));
    		
    	for (WebElement cell : cells) {
    		System.out.print(cell.getText() + " | ");
    		
    	}
        	
    	System.out.println();
    	}
    	
    	
    	
    	

       
}
}