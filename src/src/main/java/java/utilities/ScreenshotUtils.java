/*package utilities;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenshot(String testName) {

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path = System.getProperty("user.dir") + "/screenshots/"
                + testName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(srcFile, new File(path));
            System.out.println("Screenshot saved at: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;   // ✅ IMPORTANT
    }
}*/
package utilities;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }
public String takeScreenshot(String testName) {

    String path = "";

    try {
        if (driver == null) {
            System.out.println("❌ Driver is NULL, skipping screenshot");
            return "";
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        path = System.getProperty("user.dir") + "/screenshots/"
                + testName + "_" + timestamp + ".png";

        FileUtils.copyFile(srcFile, new File(path));

        System.out.println("Screenshot saved at: " + path);

    } catch (Exception e) {
        System.out.println("⚠️ Screenshot failed, but continuing test");
        e.printStackTrace();
    }

    return path;
}
}