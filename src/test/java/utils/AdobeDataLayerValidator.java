package utils;

import org.openqa.selenium.JavascriptExecutor;

public class AdobeDataLayerValidator {

    private final JavascriptExecutor js;

    public AdobeDataLayerValidator(JavascriptExecutor js) {
        if (js == null) {
            throw new IllegalArgumentException("JavascriptExecutor cannot be null");
        }
        this.js = js;
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


