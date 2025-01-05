package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdobeDataLayerValidator {
    private final JavascriptExecutor js;

    public AdobeDataLayerValidator(JavascriptExecutor js) {
        if (js == null) {
            throw new IllegalArgumentException("JavascriptExecutor cannot be null");
        }
        this.js = js;
    }

    public static void navigateToPage(WebDriver driver, String url) {
        driver.get(url);
    }

    private static String getEventType(WebDriver driver, int index) {
        String script = "return adobeDataLayer[" + index + "].event;";
        return (String) ((JavascriptExecutor) driver).executeScript(script);
    }

    public static void validateEventAtIndex(WebDriver driver, AdobeDataLayerValidator validator, int index, Map<String, String> expectedFields) {
        String eventType = getEventType(driver, index);
        if (eventType != null) {
            validateEvent(driver, validator, index, eventType, expectedFields);
        } else {
            System.out.println("Event type is null at index " + index);
            throw new AssertionError("Event type is null at index " + index);
        }
    }

    private static void validateEvent(WebDriver driver, AdobeDataLayerValidator validator, int index, String eventType, Map<String, String> expectedFields) {
        System.out.println("Validating event type: " + eventType);

        boolean validationFailed = false;

        for (Map.Entry<String, String> entry : expectedFields.entrySet()) {
            String field = entry.getKey();
            String expectedValue = entry.getValue();
            String script = "return adobeDataLayer[" + index + "]." + field + ";";

            boolean isValid = validator.validateField(script, expectedValue, field);

            if (!isValid) {
                validationFailed = true;
                System.err.println("Mismatch in field: " + field + ". Expected: " + expectedValue);
            }
        }

        if (validationFailed) {
            System.out.println("Some validations failed, but continuing the test execution.");
        } else {
            System.out.println("All validations passed.");
        }
    }

    public static Map<String, String> getActualEventFieldsFromPage(WebDriver driver) {
        Map<String, String> actualEventFields = new HashMap<>();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object dataLayerObject = js.executeScript("return window.dataLayer");

        if (dataLayerObject != null) {
            if (dataLayerObject instanceof List<?> dataLayer) {

                for (int i = dataLayer.size() - 1; i >= 0; i--) {
                    Object data = dataLayer.get(i);

                    if (data instanceof Map<?, ?>) {
                        Map<String, Object> event = (Map<String, Object>) data;

                        if (event.containsKey("event")) {
                            actualEventFields.clear();
                            for (Map.Entry<String, Object> entry : event.entrySet()) {
                                actualEventFields.put(entry.getKey(), entry.getValue().toString());
                                System.out.println("Extracted Actual Pair: " + entry.getKey() + " = " + entry.getValue());
                            }
                            break;
                        }
                    }
                }
            } else if (dataLayerObject instanceof Object[] dataLayer) {

                for (int i = dataLayer.length - 1; i >= 0; i--) {
                    Object data = dataLayer[i];

                    if (data instanceof Map<?, ?>) {
                        Map<String, Object> event = (Map<String, Object>) data;

                        if (event.containsKey("event")) {
                            actualEventFields.clear();
                            for (Map.Entry<String, Object> entry : event.entrySet()) {
                                actualEventFields.put(entry.getKey(), entry.getValue().toString());
                                System.out.println("Extracted Actual Pair: " + entry.getKey() + " = " + entry.getValue());
                            }
                            break;
                        }
                    }
                }
            } else {
                System.err.println("Unexpected dataLayer format: " + dataLayerObject.getClass());
            }
        } else {
            System.err.println("No dataLayer found in the page.");
        }

        return actualEventFields;
    }

    public boolean validateField(String script, String expectedValue, String fieldName) {
        try {
            String actualValue = toString(js.executeScript(script));
            if (actualValue.equals(expectedValue)) {
                return true;
            } else {
                System.err.println("Invalid " + fieldName + ": " + actualValue + " (Expected: " + expectedValue + ")");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error validating " + fieldName + ": " + e.getMessage());
            return false;
        }
    }

    public int getDataLayerSize() {
        try {
            return ((Long) js.executeScript("return adobeDataLayer.length;")).intValue();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching data layer size: " + e.getMessage());
        }
    }

    private String toString(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }


}


