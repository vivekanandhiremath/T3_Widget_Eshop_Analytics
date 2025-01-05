package test;

import org.testng.annotations.Test;
import page.HomePage;
import utils.AdobeDataLayerUtils;
import utils.CSVManager;

import java.util.Map;

public class AccessoriesAdobeDataLayerTest extends BaseClass {

    private static final String BASE_URL = "https://stage-dealeradmin.eshopdemo.net/widget/redesign";
    private static final String CSV_EXPECTED_FILE_PATH = "src/test/resources/testData/Anlytic_Expected_results.csv";
    private static final String CSV_ANALYTICS_RESULT_FILE_PATH = "src/test/resources/testData/Anlytic_results.csv";
    CSVManager csvmanage = new CSVManager();

    @Test
    public void validateEventForWhenAUserHasFinishedLoadingThePage() {
        Map<String, String> expectedEventFields = csvmanage.loadExpectedEventFieldsFromCSV(CSV_EXPECTED_FILE_PATH, 0, 1);

        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        hp.clickOnLeadFormCloseIcon();
        hp.clickOnAccessoriesSideMenu();

        System.out.println("Data Layer Size : Overall Event triggered Count " + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();
        if (dataLayerSize > 0) {
            try {
                Map<String, String> actualEventFields = AdobeDataLayerUtils.getActualEventFieldsFromPage(driver);
                Map<String, String> flattenedExpectedEventFields = csvmanage.flattenEventFields(expectedEventFields);
                Map<String, String> flattenedActualEventFields = csvmanage.flattenEventFields(actualEventFields);
                csvmanage.writeExpectedAndActualToCSV(CSV_ANALYTICS_RESULT_FILE_PATH, flattenedExpectedEventFields, flattenedActualEventFields);
                AdobeDataLayerUtils.validateEventAtIndex(driver, validator, dataLayerSize - 1, flattenedExpectedEventFields);
            } catch (Exception e) {
                System.err.println("Error validating event at last index: " + e.getMessage());
            }
        } else {
            System.err.println("No events found in the data layer.");
        }
    }


}

