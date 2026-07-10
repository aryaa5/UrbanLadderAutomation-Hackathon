package tests;

import com.aventstack.extentreports.Status;
import pages.SearchResultsPage;
import utils.ScreenshotUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class BookshelvesFilterTest extends BaseTest {
    HomePage homePage;
    SearchResultsPage searchPage;

    @Test(priority = 1)
    public void test01_verifyHomePageTitle() {
        extentTest.set(extent.createTest("Test 01: Verify Home Page Title"));
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getPageTitle().contains("Furniture"), "Title mismatch!");
        extentTest.get().log(Status.PASS, "Home page title verified successfully.");
    }

    @Test(priority = 2)
    public void test02_searchBookshelves() {
        extentTest.set(extent.createTest("Test 02: Search Bookshelves"));
        homePage.searchForProduct("Bookshelves");
        searchPage = new SearchResultsPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("Bookshelves"), "URL does not contain 'Bookshelves'");
        extentTest.get().log(Status.PASS, "Searched for Bookshelves successfully.");
    }

    @Test(priority = 3)
    public void test03_clickStorageTypeFilter() {
        extentTest.set(extent.createTest("Test 03: Click Storage Type Filter"));
        searchPage.clickStorageType();
        extentTest.get().log(Status.PASS, "Clicked Storage Type filter dropdown.");
    }

    @Test(priority = 4)
    public void test04_selectOpenStorageOption() {
        extentTest.set(extent.createTest("Test 04: Select Open Storage Option"));
        searchPage.selectOpenStorage();
        extentTest.get().log(Status.PASS, "Selected 'Open Storage' option.");
    }

    @Test(priority = 5)
    public void test05_clickAllFilters() {
        extentTest.set(extent.createTest("Test 05: Click All Filters"));
        searchPage.clickAllFilters();
        extentTest.get().log(Status.PASS, "Clicked on 'ALL FILTERS' panel.");
    }

    @Test(priority = 6)
    public void test09_clickAvailabilityFilter() {
        extentTest.set(extent.createTest("Test 06: Click Availability Filter"));
        searchPage.clickAvailabilityFilter();
        extentTest.get().log(Status.PASS, "Clicked Availability Filter.");
    }

    @Test(priority = 7)
    public void test10_verifyAvailabilityStatus() {
        extentTest.set(extent.createTest("Test 07: Verify Availability Status"));
        String status = searchPage.getAvailabilityCheckboxStatus();
        Assert.assertNotNull(status, "Checkbox aria-checked attribute status is null");
        extentTest.get().log(Status.PASS, "Availability status verified: " + status);
    }

    @Test(priority = 8)
    public void test06_clickPriceFilterDropdown() {
        extentTest.set(extent.createTest("Test 08: Click Price Filter Dropdown"));
        searchPage.clickPriceFilter();
        extentTest.get().log(Status.PASS, "Price filter dropdown expanded.");
    }

    @Test(priority = 9)
    public void test07_applyMaxPriceLimit() {
        extentTest.set(extent.createTest("Test 09: Set Max Price to 15000"));
        searchPage.setMaxPrice("15000");
        extentTest.get().log(Status.PASS, "Max price limit input complete.");
    }

    @Test(priority = 10)
    public void test08_clickApplyFilterButton() {
        extentTest.set(extent.createTest("Test 10: Click Apply Filter"));
        searchPage.clickApplyFilter();
        extentTest.get().log(Status.PASS, "Filters successfully applied.");
    }

    @Test(priority = 11)
    public void test11_printAndVerifyTop3Products() {
        extentTest.set(extent.createTest("Test 11: Print Top 3 Products below Rs. 15000"));
        List<WebElement> names = searchPage.getProductNames();
        List<WebElement> prices = searchPage.getProductPrices();
        Assert.assertTrue(names.size() >= 3, "Fewer than 3 products found!");

        System.out.println("--- TOP 3 BOOKSHELVES ---");
        for(int i = 0; i < 3; i++){
            System.out.println(names.get(i).getText() + " : " + prices.get(i).getText());
        }
        System.out.println("-------------------------");
        extentTest.get().log(Status.PASS, "Top 3 product names and prices extracted and printed.");
    }

    @Test(priority = 12)
    public void test12_takeSearchPageScreenshot() {
        extentTest.set(extent.createTest("Test 12: Take Search Results Screenshot"));
        String path = ScreenshotUtils.takeScreenshot(driver, "search_results");
        Assert.assertNotNull(path);
        extentTest.get().log(Status.PASS, "Search results page screenshot archived.");
    }
}