package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConfirmationPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    // Locators
    By thankYouMessage = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
    By backHomeBtn = By.id("back-to-products");

    // Methods

    // Verify Thank You message
    public boolean isThankYouMessageDisplayed() throws InterruptedException {
        boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage)).isDisplayed();
        Thread.sleep(500); // small pause for demo visibility
        return displayed;
    }

    // Click Back Home button
    public void clickBackHome() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeBtn)).click();
        Thread.sleep(1000); // pause to see transition
    }
}