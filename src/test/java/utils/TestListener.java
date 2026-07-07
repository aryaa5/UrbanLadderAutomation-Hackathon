package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import tests.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest activeTest = BaseTest.getActiveTest();

        if (activeTest != null) {
            // Log the TestNG failure details
            activeTest.log(Status.FAIL, "Test Failed: " + result.getName());
            activeTest.fail(result.getThrowable());

            // Capture Screenshot on Failure
            try {
                Object currentClass = result.getInstance();
                org.openqa.selenium.WebDriver driver = ((BaseTest) currentClass).getDriver();
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName() + "_Failed");
                activeTest.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                System.out.println("Could not attach screenshot to ExtentReport: " + e.getMessage());
            }
        } else {
            System.out.println("CRITICAL: ExtentTest instance was null for " + result.getName());
        }
    }
}