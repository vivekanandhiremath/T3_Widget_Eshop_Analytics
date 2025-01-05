package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class EventValidationUtils {

    public static boolean validateInteractionFields(Map<String, String> expectedFields, Map<String, Object> interactionData) {
        boolean isValid = true;

        for (Map.Entry<String, String> entry : expectedFields.entrySet()) {
            String expectedField = entry.getKey();
            String expectedValue = entry.getValue();

            if ("interaction.description".equals(expectedField)) {
                String fieldValue = (String) interactionData.get(expectedField);

                if (fieldValue != null && fieldValue.contains("-")) {
                    String[] descriptionParts = fieldValue.split("-");
                    String dynamicAction = descriptionParts[0];  // Extract dynamic action part

                    String expectedDescription = expectedValue.split("-")[1]; // The static part after <action>
                    if (!fieldValue.endsWith(expectedDescription)) {
                        System.out.println("Field " + expectedField + " is invalid. Expected: " + expectedValue + ", Found: " + fieldValue);
                        isValid = false;
                    }
                } else {
                    if (!fieldValue.equals(expectedValue)) {
                        System.out.println("Field " + expectedField + " is invalid. Expected: " + expectedValue + ", Found: " + fieldValue);
                        isValid = false;
                    }
                }
            } else {
                if (interactionData.containsKey(expectedField)) {
                    String fieldValue = (String) interactionData.get(expectedField);
                    if (!expectedValue.equals(fieldValue)) {
                        System.out.println("Field " + expectedField + " is invalid. Expected: " + expectedValue + ", Found: " + fieldValue);
                        isValid = false;
                    }
                } else {
                    System.out.println("Field " + expectedField + " is missing from the interaction data.");
                    isValid = false;
                }
            }
        }

        return isValid;
    }

    public static void validateEventAtIndex(WebDriver driver, AdobeDataLayerValidator validator, int index, Map<String, String> expectedFields) {
        String eventType = getEventType(driver, index);

        if (eventType != null) {
            validateEvent(driver, validator, index, eventType, expectedFields);
        } else {
            System.out.println("Event type is null at index " + index);
        }
    }

    private static String getEventType(WebDriver driver, int index) {
        String script = "return adobeDataLayer[" + index + "].event;";
        return (String) ((JavascriptExecutor) driver).executeScript(script);
    }

    public static void validateEvent(WebDriver driver, AdobeDataLayerValidator validator, int index, String eventType, Map<String, String> expectedFields) {
        System.out.println("Validating event type: " + eventType);

        expectedFields.forEach((field, expectedValue) -> {
            String script = "return adobeDataLayer[" + index + "]." + field + ";";
            String result = validator.validateField(script, expectedValue, field);
            System.out.println(result);
        });
    }

    public static boolean validateEventDataLayer(WebDriver driver, AdobeDataLayerValidator validator, int index, Map<String, Map<String, String>> expectedEvents) {
        String eventType = getEventType(driver, index);

        if (eventType != null && expectedEvents.containsKey(eventType)) {
            Map<String, String> expectedFields = expectedEvents.get(eventType);
            validateEvent(driver, validator, index, eventType, expectedFields);
            return true;
        } else {
            System.out.println("No matching event found or event type not defined: " + eventType);
            return false;
        }
    }

}
