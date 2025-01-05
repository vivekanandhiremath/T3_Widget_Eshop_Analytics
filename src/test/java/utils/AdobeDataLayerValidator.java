package utils;

import org.openqa.selenium.JavascriptExecutor;

public class AdobeDataLayerValidator {

    private final JavascriptExecutor js;

    public AdobeDataLayerValidator(JavascriptExecutor js) {
        this.js = js;
    }


    public String validateField(String script, String expectedValue, String fieldName) {
        String result;
        try {
            String actualValue = toString(js.executeScript(script));
            if (actualValue.equals(expectedValue)) {
                result = fieldName + " is valid: " + actualValue;
            } else {
                result = "Invalid " + fieldName + ": " + actualValue + " (Expected: " + expectedValue + ")";
//                throw new AssertionError(result);
            }
        } catch (Exception e) {
            result = "Error validating " + fieldName + ": " + e.getMessage();
            throw new AssertionError(result);
        }
        return result;
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


