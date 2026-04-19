package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest1;
import pages.LoginPage2;
import utilities.ExcelUtils;
import utilities.WaitUtils;

public class AmazonMultipleTests extends BaseTest1 {

    LoginPage2 login;

    @Test
    public void testMultipleLogins() {

        login = new LoginPage2(driver);
        WaitUtils wait = new WaitUtils(driver);

        String filePath = "C:\\Users\\Prashanth\\eclipse-workspace\\basicproject\\src\\test\\resources\\testdata.xlsx";
  
        SoftAssert softAssert = new SoftAssert(); // Create soft assert once

        int totalRows = ExcelUtils.getRowCount(filePath, "LoginData");

        for (int i = 1; i <= totalRows; i++) {
            String email = ExcelUtils.getCellData(filePath, "LoginData", i, 0);
            String password = ExcelUtils.getCellData(filePath, "LoginData", i, 1);

            System.out.println("Testing user: " + email);

            try {
                login.login(email, password);

                // Wait for error box or password field
                WebElement nextElement = null;
                By passwordField = By.id("ap_password");
                By errorBox = By.id("auth-error-message-box");

                for(int t = 0; t < 15; t++) {
                    if(driver.findElements(passwordField).size() > 0){
                        nextElement = driver.findElement(passwordField);
                        break;
                    }
                    if(driver.findElements(errorBox).size() > 0){
                        nextElement = driver.findElement(errorBox);
                        break;
                    }
                    Thread.sleep(1000);
                }

                softAssert.assertNotNull(nextElement, "Neither password field nor error displayed for user: " + email);

                System.out.println("Next element displayed: " + (nextElement != null ? nextElement.getText() : "None"));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Login attempt failed for user: " + email);
            }

            // Reset page for next iteration
            driver.get("https://www.amazon.in/");
        }
        softAssert.assertAll(); // collect all soft assertion results at the end
    }
}