package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
      
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public void enterUsername(String user) {
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
    }

    public void enterPassword(String pass) {
   
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }

    public void clickLogin() {
      
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

}