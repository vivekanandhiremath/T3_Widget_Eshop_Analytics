package test;

import org.testng.annotations.Test;
import page.HomePage;
import utils.AdobeDataLayerUtils;
import utils.EventValidationUtils;

import java.util.HashMap;
import java.util.Map;

public class AdobeDataLayerTestmain extends BaseClass {

    private static final String BASE_URL = "https://old-dealeradmin.eshopdemo.net/widget/redesign";
    private static final int SLEEP_TIME_MILLIS = 5000;

    @Test
    public void validateAdobeDataLayerForAccessoriesMenu() {

        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);

        Map<String, Map<String, String>> expectedEvents = new HashMap<>();

        Map<String, String> pageLoadEvent = new HashMap<>();
        pageLoadEvent.put("event", "page-load");
        pageLoadEvent.put("page.name", "build-your-deal:vehicle-details");
        expectedEvents.put("page-load", pageLoadEvent);

        Map<String, String> buttonClickEvent = new HashMap<>();
        buttonClickEvent.put("event", "button-click");
        buttonClickEvent.put("button.id", "expressBtn");
        expectedEvents.put("button-click", buttonClickEvent);

        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        hp.clickOnLeadSubmitSideMenu();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        int dataLayerSize = validator.getDataLayerSize();
        if (dataLayerSize > 0) {
            for (int index = 0; index < dataLayerSize; index++) {
                boolean isValid = EventValidationUtils.validateEventDataLayer(driver, validator, index, expectedEvents);
                if (isValid) {
                    System.out.println("Event " + index + " validated successfully.");
                } else {
                    System.out.println("Event " + index + " validation failed.");
                }
            }
        } else {
            System.err.println("No events found in the data layer.");
        }
    }
}
