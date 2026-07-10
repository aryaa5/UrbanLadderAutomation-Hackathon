package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class GiftCardsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // Locators
    private By denominationInput = By.xpath("//input[@id='denomination']");
    private By quantityInput = By.xpath("//input[@id='quantity']");
    private By designTheme = By.xpath("(//div[@class='mousePointer imageCarousel '])[position()=3]");
    private By senderFirstName = By.xpath("//input[@id='firstname']");
    private By senderLastName = By.xpath("//input[@id='lastname']");
    private By senderEmail = By.xpath("//input[@id='email']");
    private By recipientFirstName = By.xpath("(//input[@id='firstname'])[position()=2]");
    private By recipientLastName = By.xpath("(//input[@id='lastname'])[position()=2]");
    private By recipientEmail = By.xpath("(//input[@id='email'])[position()=2]");
    private By recipientPhone = By.xpath("//input[@id='telephone']");
    private By giftMessageInput = By.xpath("//textarea[@id='giftMessage']");

    public GiftCardsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void switchToGiftCardWindow() {
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            driver.switchTo().window(window);
        }
    }

    public void enterDenomination(String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(denominationInput)).sendKeys(amount);
    }

    public void enterQuantity(String qty) {
        driver.findElement(quantityInput).sendKeys(qty);
    }

    public void selectDesignTheme() {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(designTheme));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);
    }

    public void enterSenderDetails(String fName, String lName, String email) {
        driver.findElement(senderFirstName).sendKeys(fName);
        driver.findElement(senderLastName).sendKeys(lName);
        driver.findElement(senderEmail).sendKeys(email);
    }

    public void enterRecipientDetails(String fName, String lName, String email, String phone) {
        driver.findElement(recipientFirstName).sendKeys(fName);
        driver.findElement(recipientLastName).sendKeys(lName);
        driver.findElement(recipientEmail).sendKeys(email);
        driver.findElement(recipientPhone).sendKeys(phone);
    }

    public void enterGiftMessage(String message) {
        driver.findElement(giftMessageInput).sendKeys(message);
    }
}