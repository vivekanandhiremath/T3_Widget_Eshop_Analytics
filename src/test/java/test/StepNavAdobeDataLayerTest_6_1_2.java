//package test;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import page.HomePage;
//import utils.AdobeDataLayerUtils;
//import utils.CSVManager;
//
//import java.util.Map;
//
//public class StepNavAdobeDataLayerTest_6_1_2 extends BaseClass {
//    private static final String BASE_URL = "https://stage-dealeradmin.eshopdemo.net/widget/redesign";
//    private static final String CSV_EXPECTED_FILE_PATH = "src/test/resources/testData/Anlytic_Expected_results.csv";
//    private static final String CSV_ANALYTICS_RESULT_FILE_PATH = "src/test/resources/testData/Anlytic_results.csv";
//    CSVManager csvmanage = new CSVManager();
//
//    @Test
//    public void WhenAUserClicksOnASpecificStepToGoThatViewForDetailsSideMenu() {
//        Map<String, String> expectedEventFields = csvmanage.loadExpectedEventFieldsFromCSV(CSV_EXPECTED_FILE_PATH, 0, 1);
//
//        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
//        HomePage hp = new HomePage(driver);
//        hp.clickOnNewVehicles();
//        hp.handelLeadForm("name");
//
//        hp.clickOnTradeIn();
//        hp.clickOnDetailsSideMenu();
//
//        System.out.println("Data Layer Size : Overall Event triggered Count " + validator.getDataLayerSize());
//        int dataLayerSize = validator.getDataLayerSize();
//        if (dataLayerSize > 0) {
//            try {
//                Map<String, String> actualEventFields = AdobeDataLayerUtils.getActualEventFieldsFromPage(driver);
//                Map<String, String> flattenedExpectedEventFields = csvmanage.flattenEventFields(expectedEventFields);
//                Map<String, String> flattenedActualEventFields = csvmanage.flattenEventFields(actualEventFields);
//                csvmanage.writeExpectedAndActualToCSV(CSV_ANALYTICS_RESULT_FILE_PATH, flattenedExpectedEventFields, flattenedActualEventFields);
//                AdobeDataLayerUtils.validateEventAtIndex(driver, validator, dataLayerSize - 1, flattenedExpectedEventFields);
//            } catch (Exception e) {
//                System.err.println("Error validating event at last index: " + e.getMessage());
//            }
//        } else {
//            System.err.println("No events found in the data layer.");
//        }
//
//
/// /        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
/// /        int dataLayerSize = validator.getDataLayerSize();
/// /
/// /
/// /        int lastIndex = dataLayerSize - 2;
/// /
/// /        Map<String, String> expectedEventFields = Map.of(
/// /                "event", "interaction-click",
/// /                "interaction.site", "dealer",
/// /                "interaction.type", "nav",
/// /                "interaction.page", "build-your-deal:trade-in",
/// /                "interaction.location", "step-navigation",
/// /                "interaction.description", "build-your-deal:vehicle-details"
/// /        );
//
//
////        try {
////            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
////            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
////        } catch (Exception e) {
////            System.err.println("Error validating event at last index: " + e.getMessage());
////            Assert.fail("Error validating event at last index: " + e.getMessage());
////            collectAssertionFailure(e.getMessage());
////        }
//
//    }
//
//    @Test
//    public void WhenAUserClicksOnASpecificStepToGoThatViewForTradeInSideMenu() {
//        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
//        HomePage hp = new HomePage(driver);
//        hp.clickOnNewVehicles();
//        hp.handelLeadForm("name");
//
//        hp.clickOnTradeIn();
//
//        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
//        int dataLayerSize = validator.getDataLayerSize();
//
//
//        int lastIndex = dataLayerSize - 2;
//
//        Map<String, String> expectedEventFields = Map.of(
//                "event", "interaction-click",
//                "interaction.site", "dealer",
//                "interaction.type", "nav",
//                "interaction.page", "build-your-deal:vehicle-details",
//                "interaction.location", "step-navigation",
//                "interaction.description", "build-your-deal:trade-in"
//        );
//
//
//        try {
//            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
//            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
//        } catch (Exception e) {
//            System.err.println("Error validating event at last index: " + e.getMessage());
//            Assert.fail("Error validating event at last index: " + e.getMessage());
//            collectAssertionFailure(e.getMessage());
//        }
//
//    }
//
//    @Test
//    public void WhenAUserClicksOnASpecificStepToGoThatViewForProtectionSideMenu() {
//        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
//        HomePage hp = new HomePage(driver);
//        hp.clickOnNewVehicles();
//        hp.handelLeadForm("name");
//
//        hp.clickOnProtection();
//
//        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
//        int dataLayerSize = validator.getDataLayerSize();
//
//
//        int lastIndex = dataLayerSize - 2;
//
//        Map<String, String> expectedEventFields = Map.of(
//                "event", "interaction-click",
//                "interaction.site", "dealer",
//                "interaction.type", "nav",
//                "interaction.page", "build-your-deal:vehicle-details",
//                "interaction.location", "step-navigation",
//                "interaction.description", "build-your-deal:service-and-protection"
//        );
//
//
//        try {
//            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
//            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
//        } catch (Exception e) {
//            System.err.println("Error validating event at last index: " + e.getMessage());
//            Assert.fail("Error validating event at last index: " + e.getMessage());
//            collectAssertionFailure(e.getMessage());
//        }
//
//    }
//
//    @Test
//    public void WhenAUserClicksOnASpecificStepToGoThatViewForAccessoriesSideMenu() {
//        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
//        HomePage hp = new HomePage(driver);
//        hp.clickOnNewVehicles();
//        hp.handelLeadForm("name");
//
//        hp.clickOnAccessoriesSideMenu();
//
//        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
//        int dataLayerSize = validator.getDataLayerSize();
//
//
//        int lastIndex = dataLayerSize - 2;
//
//        Map<String, String> expectedEventFields = Map.of(
//                "event", "interaction-click",
//                "interaction.site", "dealer",
//                "interaction.type", "nav",
//                "interaction.page", "build-your-deal:vehicle-details",
//                "interaction.location", "step-navigation",
//                "interaction.description", "build-your-deal:chargers-and-accessories"
//        );
//
//
//        try {
//            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
//            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
//        } catch (Exception e) {
//            System.err.println("Error validating event at last index: " + e.getMessage());
//            Assert.fail("Error validating event at last index: " + e.getMessage());
//            collectAssertionFailure(e.getMessage());
//        }
//
//    }
//
//    @Test
//    public void WhenAUserClicksOnASpecificStepToGoThatViewForSubmitSideMenu() {
//        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
//        HomePage hp = new HomePage(driver);
//        hp.clickOnNewVehicles();
//        hp.handelLeadForm("name");
//
//        hp.clickOnSubmitSideMenu();
//
//        System.out.println("Data Layer Size : Overall Event triggered Count :" + validator.getDataLayerSize());
//        int dataLayerSize = validator.getDataLayerSize();
//
//
//        int lastIndex = dataLayerSize - 2;
//
//        Map<String, String> expectedEventFields = Map.of(
//                "event", "interaction-click",
//                "interaction.site", "dealer",
//                "interaction.type", "nav",
//                "interaction.page", "build-your-deal:vehicle-details",
//                "interaction.location", "step-navigation",
//                "interaction.description", "build-your-deal:confirm-your-deal"
//        );
//
//
//        try {
//            AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);
//            Assert.assertTrue(true, "Event at index " + lastIndex + " is valid.");
//        } catch (Exception e) {
//            System.err.println("Error validating event at last index: " + e.getMessage());
//            Assert.fail("Error validating event at last index: " + e.getMessage());
//            collectAssertionFailure(e.getMessage());
//        }
//
//    }
//
//}
