package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Wait {

    @Test
    public void getProductsAbove50K() throws InterruptedException {

        // Step 1: Launch Browser
        WebDriver driver = new ChromeDriver();

        // Step 2: Open Amazon
        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();

        // Step 3: Search Product (Example: iPhone)
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(3000); // better to use explicit wait in real-time

        // Step 4: Get all product containers
        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']")
        );

        System.out.println("Total Products: " + products.size());

        // Step 5: Loop through each product
        for (WebElement product : products) {

            try {
                // Product Name
                String name = product.findElement(By.xpath(".//h2")).getText();

                // Product Price
                String priceText = product.findElement(
                        By.xpath(".//span[@class='a-price-whole']")
                ).getText();

                // Clean price (remove commas)
                priceText = priceText.replaceAll("[^0-9]", "");

                int price = Integer.parseInt(priceText);

                // Step 6: Condition
                if (price > 50000) {
                    System.out.println(name + " -> " + price);
                }

            } catch (Exception e) {
                // Some products may not have price
                continue;
            }
        }

        // Step 7: Close Browser
        driver.quit();
    }
}