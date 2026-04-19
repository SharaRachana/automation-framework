package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        // Explicit wait up to 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueBtn = By.id("continue");

    // Methods

    /**
     * Enter First Name
     */
    public void enterFirstName(String firstName) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        // Optional: type character by character for demo
        for (char c : firstName.toCharArray()) {
            el.sendKeys(String.valueOf(c));
        }
    }

    /**
     * Enter Last Name
     */
    public void enterLastName(String lastName) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        for (char c : lastName.toCharArray()) {
            el.sendKeys(String.valueOf(c));
        }
    }

    /**
     * Enter ZIP / Postal Code
     */
    public void enterZip(String zip) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField));
        el.sendKeys(zip);
    }

    /**
     * Click Continue button
     */
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }
}