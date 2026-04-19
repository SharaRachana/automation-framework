package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage1 {
	
	public WebDriver driver;
	public Properties prop;
	
	 public LoginPage1(WebDriver driver, Properties prop) {
		 this.driver = driver;
		 this.prop = prop;
	 }
	 public void clickSignIn() throws IOException{
		
		 driver.findElement(By.id(prop.getProperty("signin"))).click();
	 }
	 public void emailEnter(String email){
			
		 driver.findElement(By.id(prop.getProperty("email"))).sendKeys(email);
	 }
	/*public void clickContinue() {
			
		 driver.findElement(By.id(prop.getProperty("continue"))).click();
		 
	}*/
	 public void clickContinue() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.elementToBeClickable(
		            By.id(prop.getProperty("continueBtn")))).click();
		}
	public void passwordEnter(String password) {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.id(prop.getProperty("password")))).sendKeys(password);
		}
	

	 public void SignIn() throws IOException{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.elementToBeClickable(
		            By.id(prop.getProperty("signInButton")))).click();
			
		
	 }
	 
	 }

	

