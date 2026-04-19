package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        // Explicit wait up to 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By backpackItem = By.className("inventory_item_name"); // Example: check for "Sauce Labs Backpack"
    By checkoutBtn = By.id("checkout");

    // Methods

    /**
     * Check if Backpack is present in Cart
     */
    public boolean isBackpackInCart() {
        try {
            WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(backpackItem));
            return item.getText().contains("Sauce Labs Backpack");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click Checkout button to proceed
     */
    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }
}