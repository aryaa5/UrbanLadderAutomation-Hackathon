package tests;

import com.aventstack.extentreports.Status;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectionsMenuTest extends BaseTest {
    HomePage homePage;

    @Test(priority = 1)
    public void test13_hoverLivingMenu() {
        extentTest.set(extent.createTest("Test 13: Hover Living Menu"));
        homePage = new HomePage(driver);
        homePage.hoverOverLivingMenu();
        extentTest.get().log(Status.PASS, "Hover event performed on Living menu.");
    }

    @Test(priority = 2)
    public void test14_extractCategoryMenuContent() {
        extentTest.set(extent.createTest("Test 14: Extract Sub-menu Items under Living"));
        String menuText = homePage.getCategoryMenuText();
        Assert.assertFalse(menuText.isEmpty(), "Category menu text content is empty!");
        System.out.println("--- LIVING MENU CONTENT ---");
        System.out.println(menuText);
        System.out.println("-------------------------");
        extentTest.get().log(Status.PASS, "Retrieved and displayed sub-menu category text blocks.");
    }
}