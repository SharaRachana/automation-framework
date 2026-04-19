package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        // Explicit wait up to 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(50000));
    }

    // Locators
    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cart = By.className("shopping_cart_link");

    // Methods
    public void addProduct() {
        // Wait until the Add to Cart button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    public void openCart() throws InterruptedException{
        // Wait until the Cart icon is clickable
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
        Thread.sleep(1000);
    }
}