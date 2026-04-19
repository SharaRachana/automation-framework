package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest1;
import pages.LoginPage2;

import org.testng.Assert;

@Listeners(listeners.TestListener.class)
public class AmazonLoginTest1 extends BaseTest1 {

    LoginPage2 login;

    @Test(dataProvider = "loginData")
    public void testlogin(String email, String password) {

        login = new LoginPage2(driver);  // ✅ correct

        login.login(email, password);

        Assert.assertTrue(driver.getTitle().contains("Amazon"),
                "Page not loaded");
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"7032420618", "Candy@3107"},
                {"9515564714", "Rachu"}
        };
    }
}