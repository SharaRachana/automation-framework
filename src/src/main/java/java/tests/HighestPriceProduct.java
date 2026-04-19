package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighestPriceProduct {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
		);
		searchBox.sendKeys("iPhone");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		int maxPrice = 0;
		String maxProductName= "";
		
		for(WebElement product : products) {
			String name = product.findElement(By.xpath(".//h2//span")).getText();
			String PriceText = product.findElement(By.xpath(".//span[@class='a-price-whole']")).getText().replace(",","");
			int Price =Integer.parseInt(PriceText);
			
			if(Price>maxPrice) {
				maxPrice = Price;
				maxProductName = name;
				System.out.println("Highest Price Product:");
		        System.out.println("Name: " + maxProductName);
		        System.out.println("Price: " + maxPrice);
				
			}
			
		}
		
		
		
		
		
		
		
		
	}

}
