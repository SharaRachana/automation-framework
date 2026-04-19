package pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
	public WebDriver driver;
	public Properties prop;
	
	 public SearchPage(WebDriver driver, Properties prop) {
		 this.driver = driver;
		 this.prop = prop;
	 }


	 
	 public void clickSearchitems(String category) {
		 
		 WebElement dropdwn = driver.findElement(By.id(prop.getProperty("searchProd")));
		 Select s = new Select(dropdwn);
		 s.selectByVisibleText(category);
		 
	 }
	 public void searchproduct(String amazontv){
			
		 driver.findElement(By.id(prop.getProperty("serachbox"))).sendKeys(amazontv);
	 }
	 public void searchbutton(){
			
		 driver.findElement(By.id(prop.getProperty("serachbox"))).click();
	
}
}
