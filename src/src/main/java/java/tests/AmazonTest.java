package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage2;


public class AmazonTest {
    WebDriver driver;
    LoginPage2 Login;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        Reporter.getCurrentTestResult()
        .getTestContext()
        .setAttribute("driver", driver);
        Login = new LoginPage2(driver);}
    @Test
    public void Homepage() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(driver -> driver.getTitle().toLowerCase().contains("amazon"));

    	    Assert.assertTrue(driver.getTitle().toLowerCase().contains("amazon"),
    	            "Page title is incorrect");	
    	    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            Assert.assertTrue(searchBox.isDisplayed(), "Search box is not visible");
            // Find the logo element
            WebElement logo = driver.findElement(By.id("nav-logo-sprites"));

            // Assertion: Check if logo is displayed
            Assert.assertTrue(logo.isDisplayed(), "Amazon logo is not visible!");
    }

    @Test
    public void testlogin() {
        Login.login("testuser@example.com", "password123");
    }

    @AfterClass
    
    public void tearDown() {
        driver.quit();
    }
}