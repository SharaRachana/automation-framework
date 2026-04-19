package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest1 {
    
    protected ChromeDriver driver;   // ✅ FIXED


    @BeforeMethod
    public void setup(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/"); // Navigate immediately
        context.setAttribute("driver", driver);

        System.out.println("ahdqwfajyd");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}