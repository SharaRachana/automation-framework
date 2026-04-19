package listeners;

import org.testng.*;
import org.openqa.selenium.WebDriver;

import utilities.ExtentManager;
import utilities.ScreenshotUtils;

import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // 🔹 Test Start
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("✅ onTestStart triggered");

        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    // 🔹 Test Success
    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed ✅");
    }

    // 🔹 Test Failure
    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("🔥 Listener triggered - Test Failed");

        // Safety check
        if (test.get() == null) {
            ExtentTest extentTest = extent.createTest(result.getName());
            test.set(extentTest);
        }

        test.get().fail("Test Failed ❌");

        // ✅ Get driver safely
        WebDriver driver = null;

        try {
            driver = (WebDriver) result.getTestContext().getAttribute("driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ IMPORTANT: Null check
        if (driver != null) {
            try {
                ScreenshotUtils screenshot = new ScreenshotUtils(driver);
                String path = screenshot.takeScreenshot(result.getName());

                test.get().addScreenCaptureFromPath(path);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("⚠️ Driver is NULL - Screenshot skipped");
        }
    }

    // 🔹 Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        if (test.get() == null) {
            ExtentTest extentTest = extent.createTest(result.getName());
            test.set(extentTest);
        }

        test.get().skip("Test Skipped ⚠️");
    }

    // 🔹 Finish Execution
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}