package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	public Properties prop;
	
	 public HomePage(WebDriver driver, Properties prop) {
		 this.driver = driver;
		 this.prop = prop;
	 }
	 public void clickAllItems() throws IOException{
		
		 driver.findElement(By.id(prop.getProperty("clickAll"))).click();
	 }
	
	 public void DropItems() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath(prop.getProperty("DropItems"))
	        )).click();
	    }
	 public void clickFirstProduct() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath(prop.getProperty("firstProduct"))
	        )).click();
	    }
	 public void clickAddCart() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.id(prop.getProperty("addCart"))
	        )).click();
	    }
	 public void proceedcart() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath(prop.getProperty("ProceedCart"))
	        )).click();
	    }
	 
	 public void COD() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath(prop.getProperty("COD"))
	        )).click();
	    }
	 public void checkout() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    WebElement checkoutBtn = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath(prop.getProperty("checkout"))
		            )
		    );

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);

		    checkoutBtn.click();
		}
	    }
