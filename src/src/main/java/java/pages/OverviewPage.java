package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By finishBtn = By.id("finish");
    By backpackName = By.xpath("//div[text()='Sauce Labs Backpack']");
    By bikeLightName = By.xpath("//div[text()='Sauce Labs Bike Light']");
    By totalPrice = By.className("summary_total_label"); // total price element

    // Methods

    // Verify if Backpack is in Overview
    public boolean isBackpackVisible() throws InterruptedException {
        boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(backpackName)).isDisplayed();
        Thread.sleep(500); // small pause to see the element
        return displayed;
    }

    // Verify if Bike Light is in Overview
    public boolean isBikeLightVisible() throws InterruptedException {
        boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(bikeLightName)).isDisplayed();
        Thread.sleep(500);
        return displayed;
    }

    // Get total price
    public String getTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();
    }

    // Click Finish button
    public void clickFinish() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
        Thread.sleep(1000); // pause to see the transition
    }
}