package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    private By storageTypeDropdown = By.xpath("//span[.='Storage Type']");
    private By storageOptions = By.xpath("//*[contains(text(),'Storage')]");
    private By allFiltersButton = By.xpath("//div[.='ALL FILTERS']");
    private By priceFilter = By.xpath("//div[@aria-label='Price']");
    private By maxPriceInput = By.xpath("//input[contains(@aria-label,'Maximum value')]");
    private By applyFilterButton = By.xpath("//button[.='Apply Filter']");
    private By availabilityFilter = By.xpath("//div[@aria-label='Availability']");
    private By availabilityCheckbox = By.xpath("//div[@role='checkbox']");
    private By productNames = By.xpath("//h2[@class='XxwSy']");
    private By productPrices = By.xpath("//div[@class='UYQNp']");


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStorageType() {
        driver.findElement(storageTypeDropdown).click();
    }

    public void selectOpenStorage() {
        List<WebElement> list = driver.findElements(storageOptions);
        for(WebElement l : list) {
            if(l.getText().equals("Open Storage")){
                l.click();
                break;
            }
        }
    }

    public void clickAllFilters() {
        driver.findElement(allFiltersButton).click();
    }

    public void clickPriceFilter() {
        driver.findElement(priceFilter).click();
    }

    public void setMaxPrice(String price) {
        WebElement maxPrice = driver.findElement(maxPriceInput);
        maxPrice.clear();
        maxPrice.sendKeys(price);
        driver.findElement(priceFilter).click();
    }

    public void clickApplyFilter() {
        driver.findElement(applyFilterButton).click();
    }

    public void clickAvailabilityFilter() {
        driver.findElement(availabilityFilter).click();
    }

    public String getAvailabilityCheckboxStatus() {
        return driver.findElement(availabilityCheckbox).getAttribute("aria-checked");
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }
}