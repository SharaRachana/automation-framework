package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;
    public  Properties prop;
    public WebDriverWait wait;
    
 
    
  

    @BeforeMethod
    public void setup() throws IOException {

    	prop  = new Properties();
        FileInputStream f = new FileInputStream("src/test/resources/config.properties");
        
        
        prop.load(f);
        
        
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get(prop.getProperty("url"));

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}