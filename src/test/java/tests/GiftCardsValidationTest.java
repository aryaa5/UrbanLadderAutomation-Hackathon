package tests;

import com.aventstack.extentreports.Status;
import pages.GiftCardsPage;
import pages.HomePage;
import utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftCardsValidationTest extends BaseTest {
    HomePage homePage;
    GiftCardsPage giftPage;

    @Test(priority = 1)
    public void test15_navigateToGiftCards() {
        extentTest.set(extent.createTest("Test 15: Navigate to Gift Cards"));
        homePage = new HomePage(driver);
        homePage.clickGiftCards();
        giftPage = new GiftCardsPage(driver);
        giftPage.switchToGiftCardWindow();
        extentTest.get().log(Status.PASS, "Switched successfully to Gift Cards window tab.");
    }

    @Test(priority = 2)
    public void test17_enterGiftCardParameters() {
        extentTest.set(extent.createTest("Test 17: Enter Customization Parameters"));
        giftPage.enterDenomination("5000");
        giftPage.enterQuantity("2");
        extentTest.get().log(Status.PASS, "Denomination amount ($5000) and Quantity (2) added.");
    }

    @Test(priority = 3)
    public void test16_selectGiftCardDesignTheme() {
        extentTest.set(extent.createTest("Test 16: Select Design Theme"));
        giftPage.selectDesignTheme();
        extentTest.get().log(Status.PASS, "Design theme selection complete.");
    }


    @Test(priority = 4)
    public void test18_fillSenderDetails() {
        extentTest.set(extent.createTest("Test 18: Fill Sender Forms"));
        giftPage.enterSenderDetails("Chandrica", "Palani", "pchandrica05@gmail.com");
        extentTest.get().log(Status.PASS, "Sender forms populated.");
    }

    @Test(priority = 5)
    public void test19_fillRecipientDetailsWithInvalidEmail() {
        extentTest.set(extent.createTest("Test 19: Fill Recipient Forms with Invalid Email"));
        // 'Subash@gmail' intentionally lacks top-level domain syntax to trigger UI error message context
        giftPage.enterRecipientDetails("Arjun", "Kumar", "Arjun-=", "94824");
        giftPage.enterGiftMessage("Sample Message");
        extentTest.get().log(Status.PASS, "Recipient profiles handled with incomplete email syntax.");
    }

    @Test(priority = 6)
    public void test20_takeFinalGiftCardScreenshot() {
        extentTest.set(extent.createTest("Test 20: Take Gift Card Page Verification Snapshot"));
        String path = ScreenshotUtils.takeScreenshot(driver, "gift_cards_validation_state");
        Assert.assertNotNull(path);
        extentTest.get().log(Status.PASS, "Final verification snapshot committed.");
    }
}