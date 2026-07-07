package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import utils.ConfigReader;
import utils.ExtentReportManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;
    protected static ExtentReports extent = ExtentReportManager.getInstance();

    // Public static ThreadLocal so the TestListener can easily track parallel or sequential logs
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeClass
    public void setUp() {
        config = new ConfigReader();
        if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(config.getProperty("implicitWait"))));
        driver.get(config.getProperty("url"));
        //handleMarketingPopup();
    }

    private void handleMarketingPopup() {
        try {
            System.out.println("Checking for popup...");
            Thread.sleep(5000);

            WebElement shadowHost = driver.findElement(By.cssSelector("ct-web-popup-imageonly"));

            if (shadowHost.isDisplayed()) {
                SearchContext shadowRoot = shadowHost.getShadowRoot();
                shadowRoot.findElement(By.id("close")).click();
                System.out.println("Popup found and closed!");
            } else {
                System.out.println("Popup is hidden. Moving on.");
            }

        } catch (Exception e) {
            System.out.println("Popup did not appear. Moving on smoothly.");
        }
    }


    public static ExtentTest getActiveTest() {
        return extentTest.get();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}