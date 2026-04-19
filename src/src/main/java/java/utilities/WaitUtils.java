package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Explicit Wait for visibility
    public WebElement waitForVisibility(By locator, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            String message = "Element not visible after " + timeoutSeconds + " seconds: " + locator;
            System.out.println(message);
            LogUtils.error(message);
            throw e;  // Rethrow to fail the test instead of returning null
        }
    }

    // ✅ Fluent Wait
    public WebElement fluentWait(final By locator, int timeoutSeconds, int pollingSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofSeconds(pollingSeconds))
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

            return wait.until(driver -> driver.findElement(locator));

        } catch (TimeoutException e) {
            String message = "Element not found with fluent wait: " + locator;
            System.out.println(message);
            LogUtils.error(message);
            throw e; // Important to fail the test
        }
    }
}