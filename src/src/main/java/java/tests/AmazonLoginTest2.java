package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage1;
import pages.SearchPage;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonLoginTest2 extends BaseTest {
	
	@Test
	public void AmazonLoginTest() throws IOException, InterruptedException {
		LoginPage1 login = new LoginPage1(driver,prop);
		 HomePage home = new HomePage(driver, prop);
		SearchPage search = new SearchPage(driver,prop);
		
		login.clickSignIn();
		login.emailEnter("7032420618");
		Thread.sleep(2000);
		login.clickContinue();
		Thread.sleep(2000);
		login.passwordEnter("Candy@3107");
		Thread.sleep(2000);
	    login.SignIn();
	home.clickAllItems();

	home.DropItems();
		
	home.clickFirstProduct();
	Thread.sleep(3000);
	String parent = driver.getWindowHandle();

	Set<String> windows = driver.getWindowHandles();

	for(String window : windows) {

	    if(!window.equals(parent)) {
	        driver.switchTo().window(window);		    }
	}	Thread.sleep(3000);

	home.clickAddCart();
		home.proceedcart();

	Thread.sleep(3000);

	home.COD();
	home.checkout();
	    
	    search.clickSearchitems("Amazon Devices");
	    Thread.sleep(2000);	  
	    search.searchproduct("amazontv");
	    search.searchbutton();
	    
		
		
	
	}
	

}
