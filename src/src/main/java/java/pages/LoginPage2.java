package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.LogUtils;
import utilities.WaitUtils;

public class LoginPage2 {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By signInBtn = By.id("nav-link-accountList-nav-line-1");
    private By emailField = By.id("ap_email_login");
    private By continueBtn = By.id("continue");
    private By passwordField = By.id("ap_password");

    
    private By signInSubmitBtn = By.id("signInSubmit");

    public LoginPage2(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    

   
    public void login(String email, String password) {

    	System.out.println("**************************************************");
        LogUtils.info("Clicking Sign In button");
        waitUtils.waitForVisibility(signInBtn, 20).click();

        LogUtils.info("Entering email");
        waitUtils.waitForVisibility(emailField, 10).sendKeys(email);

        LogUtils.info("Clicking Continue");
        waitUtils.waitForVisibility(continueBtn, 10).click();

        LogUtils.info("Entering password");
        waitUtils.waitForVisibility(passwordField, 10).sendKeys(password);

        LogUtils.info("Clicking Sign In Submit");
        waitUtils.waitForVisibility(signInSubmitBtn, 10).click();

        LogUtils.info("Login action completed");
    }
}