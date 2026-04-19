package tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Price {
	
	public static void main(String args[]) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
		);

		searchBox.sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(10);
        // 3. Get all products
        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']")
        );
		for( WebElement product:products) {
			
			String name = product.findElement(By.xpath(".//h2//span")).getText();
			
			String PriceText = product.findElement(By.xpath(".//span[@class='a-price-whole']")).getText().replace(",","");
			int Price = Integer . parseInt(PriceText);
			
			
			if(Price>5000) {
				 System.out.println("Product: " + name);
                 System.out.println("Price: " + Price);
                 System.out.println("-------------------------");
			}
	              
			
			
		}
		
		
		
	}

}
