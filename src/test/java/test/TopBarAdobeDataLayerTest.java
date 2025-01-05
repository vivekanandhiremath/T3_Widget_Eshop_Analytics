package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DetailsPage;
import page.HomePage;
import utils.AdobeDataLayerUtils;

import java.util.Map;

public class TopBarAdobeDataLayerTest extends BaseClass {

    private static final String BASE_URL = "https://old-dealeradmin.eshopdemo.net/widget/redesign";
    private static final int SLEEP_TIME_MILLIS = 5000;

    @Test(priority = 1)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForVehicleDetailsPage() {

        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        hp.clickOnTopNavBarClose();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:vehicle-details",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );


        try {
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
            collectAssertionFailure(e.getMessage());
        }
    }

    @Test(priority = 2)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForVehicleTestDrivePage() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        DetailsPage dp = new DetailsPage(driver);
        dp.clickOnTestDrive();
        hp.clickOnTopNavBarClose();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "schedule-a-test-drive",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );

        try {
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForTradeInPage() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnTradeIn();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnTopNavBarClose();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:trade-in",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );

        try {
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForProtectionPage() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnProtection();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnTopNavBarClose();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:service-and-protection",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );

        try {
            // Validate event at the last index
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForAccessoriesPage() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnAccessoriesSideMenu();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnTopNavBarClose();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:chargers-and-accessories",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );

        try {
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForSubmitPage() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnSubmitSideMenu();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnTopNavBarClose();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:confirm-your-deal",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );

        try {
            // Validate event at the last index
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
        }
    }

    @Test(priority = 7, enabled = false)
    public void validateEventForWhenAUserClicksXIconOnTheMainSiteModalToCloseTheIframeForApplyForCreditPage() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnApplyForCredit();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnTopNavBarClose();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 1;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:confirm-your-deal",
                "interaction.location", "topnav",
                "interaction.description", "close-eshop-modal"
        );

        try {
            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
        } catch (Exception e) {
            System.err.println("Error validating event at last index: " + e.getMessage());
            Assert.fail("Error validating event at last index: " + e.getMessage());
        }
    }
}
