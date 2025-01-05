package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AdobeDataLayerUtils {

    public static void navigateToPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static String getEventType(WebDriver driver, int index) {
        String script = "return adobeDataLayer[" + index + "].event;";
        return (String) ((JavascriptExecutor) driver).executeScript(script);
    }

    public static void validateEventAtIndex(WebDriver driver, AdobeDataLayerValidator validator, int index, Map<String, String> expectedFields) {
        String eventType = getEventType(driver, index);

        if (eventType != null) {
            EventValidationUtils.validateEvent(driver, validator, index, eventType, expectedFields); // Validate the event dynamically
        } else {
            System.out.println("Event type is null at index " + index);
        }
    }

    public static void validateEvent(WebDriver driver, AdobeDataLayerValidator validator, int index, String eventType, Map<String, String> expectedFields) {
        System.out.println("Validating event type: " + eventType);

        expectedFields.forEach((field, expectedValue) -> {
            String script = "return adobeDataLayer[" + index + "]." + field + ";";
            String result = validator.validateField(script, expectedValue, field);
            System.out.println(result);
        });
    }
}
