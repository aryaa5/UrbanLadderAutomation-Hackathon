package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String path = "src/test/java/Screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        return path;
    }
}