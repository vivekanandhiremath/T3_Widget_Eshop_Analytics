package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import utils.AdobeDataLayerUtils;

import java.util.Map;

public class StepNavAdobeDataLayerTest_6_1_2 extends BaseClass {
    private static final String BASE_URL = "https://old-dealeradmin.eshopdemo.net/widget/redesign";

    @Test
    public void WhenAUserClicksOnASpecificStepToGoThatViewForDetailsSideMenu() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        hp.clickOnLeadFormCloseIcon();

        hp.clickOnTradeIn();
        hp.clickOnDetailsSideMenu();

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 2;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:trade-in",
                "interaction.location", "step-navigation",
                "interaction.description", "build-your-deal:vehicle-details"
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

    @Test
    public void WhenAUserClicksOnASpecificStepToGoThatViewForTradeInSideMenu() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        hp.clickOnLeadFormCloseIcon();

        hp.clickOnTradeIn();

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 2;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:vehicle-details",
                "interaction.location", "step-navigation",
                "interaction.description", "build-your-deal:trade-in"
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

    @Test
    public void WhenAUserClicksOnASpecificStepToGoThatViewForProtectionSideMenu() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        hp.clickOnLeadFormCloseIcon();

        hp.clickOnProtection();

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 2;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:vehicle-details",
                "interaction.location", "step-navigation",
                "interaction.description", "build-your-deal:service-and-protection"
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

    @Test
    public void WhenAUserClicksOnASpecificStepToGoThatViewForAccessoriesSideMenu() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        hp.clickOnLeadFormCloseIcon();

        hp.clickOnAccessoriesSideMenu();

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 2;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:vehicle-details",
                "interaction.location", "step-navigation",
                "interaction.description", "build-your-deal:chargers-and-accessories"
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

    @Test
    public void WhenAUserClicksOnASpecificStepToGoThatViewForSubmitSideMenu() {
        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        hp.clickOnLeadFormCloseIcon();

        hp.clickOnSubmitSideMenu();

        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();


        int lastIndex = dataLayerSize - 2;

        Map<String, String> expectedEventFields = Map.of(
                "event", "interaction-click",
                "interaction.site", "dealer",
                "interaction.type", "nav",
                "interaction.page", "build-your-deal:vehicle-details",
                "interaction.location", "step-navigation",
                "interaction.description", "build-your-deal:confirm-your-deal"
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

}
