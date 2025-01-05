package test;

import org.testng.annotations.Test;
import page.HomePage;
import utils.AdobeDataLayerUtils;

import java.util.Map;

public class AccessoriesAdobeDataLayerTest extends BaseClass {

    private static final String BASE_URL = "https://old-dealeradmin.eshopdemo.net/widget/redesign";
    private static final int SLEEP_TIME_MILLIS = 5000;

    @Test
    public void validateEventForWhenAUserHasFinishedLoadingThePage() {

        AdobeDataLayerUtils.navigateToPage(driver, BASE_URL);
        HomePage hp = new HomePage(driver);
        hp.clickOnNewVehicles();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        hp.clickOnLeadFormCloseIcon();
        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);

        hp.clickOnLeadAccessoriesSideMenu();

        AdobeDataLayerUtils.sleep(SLEEP_TIME_MILLIS);
        System.out.println("Data Layer Size : Overall Event triggered Count" + validator.getDataLayerSize());
        int dataLayerSize = validator.getDataLayerSize();
        if (dataLayerSize > 0) {
            int lastIndex = dataLayerSize - 1;

            Map<String, String> expectedEventFields = Map.of(
                    "event", "page-load",
                    "dealer.code", "44990",
                    "page.name", "build-your-deal:chargers-and-accessories",
                    "page.type", "build-your-deal",
                    "page.site", "dealer",
                    "platform.technology", "carzato",
                    "user.language", "en-US",
                    "user.responsiveState", "desktop"
            );

            try {
                AdobeDataLayerUtils.validateEventAtIndex(driver, validator, lastIndex, expectedEventFields);

            } catch (Exception e) {
                System.err.println("Error validating event at last index: " + e.getMessage());
            }
        } else {
            System.err.println("No events found in the data layer.");
        }
    }

//        for (int index = 0; index < dataLayerSize; index++) {
//            try {
//                AdobeDataLayerUtils.validateEventAtIndex(driver, validator, index);
//            } catch (Exception e) {
//                System.err.println("Error validating event at index " + index + ": " + e.getMessage());
//            }
//        }

}

