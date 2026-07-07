package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By searchInput = By.cssSelector("#searchInput");
    private By livingMenu = By.xpath("//span[.='Living']");
    private By categoryMenu = By.xpath("//div[@id='category-menu-3']");
    private By giftCardsLink = By.xpath("//a[.='Gift Cards']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName, Keys.ENTER);
    }

    public void hoverOverLivingMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(livingMenu)).perform();
    }

    public String getCategoryMenuText() {
        return driver.findElement(categoryMenu).getText();
    }

    public void clickGiftCards() {
        driver.findElement(giftCardsLink).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}