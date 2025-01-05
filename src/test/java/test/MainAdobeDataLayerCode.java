//package test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class MainAdobeDataLayerCode {
//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//
//        try {
//            driver.get("https://old-dealeradmin.eshopdemo.net/widget/redesign");
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='expressBtn'])[1]"))).click();
//
//            Thread.sleep(5000);
//
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            Object adobeDataLayer = js.executeScript("return adobeDataLayer;");
//            System.out.println("Adobe Data Layer: " + adobeDataLayer);
//
//            if (adobeDataLayer != null) {
//                String validationResult = validateAdobeDataLayer(js);
//                System.out.println(validationResult);
//            } else {
//                System.out.println("Adobe Data Layer is null or not available.");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }
//
//    private static String toString(Object obj) {
//        return (obj == null) ? "" : obj.toString();
//    }
//
//    private static String validateAdobeDataLayer(JavascriptExecutor js) {
//        String result = "";
//
//        String expectedDealerCode = "44990";
//        String expectedEvent = "page-load";
//        String expectedPageName = "build-your-deal:vehicle-details";
//        String expectedSite = "dealer";
//        String expectedPlatformTechnology = "carzato";
//        String expectedLanguage = "en-US";
//        String expectedZipCode = "77450";
//        String expectedVehicleMake = "dodge";
//        String expectedVehicleModel = "charger";
//        String expectedVehicleTrim = "sxt";
//        String expectedVehicleVin = "2c3cdxbgxph656415";
//        int expectedVehicleYear = 2023;
//
//        try {
//            for (int i = 0; i < 2; i++) {
//                String dealerCode = toString(js.executeScript("return adobeDataLayer[" + i + "].dealer.code;"));
//                if (dealerCode.equals(expectedDealerCode)) {
//                    result += "Dealer code is valid: " + dealerCode + "\n";
//                } else {
//                    result += "Invalid dealer code at index " + i + ": " + dealerCode + "\n";
//                }
//
//                String event = toString(js.executeScript("return adobeDataLayer[" + i + "].event;"));
//                if (event.equals(expectedEvent)) {
//                    result += "Event is valid: " + event + "\n";
//                } else {
//                    result += "Invalid event at index " + i + ": " + event + "\n";
//                }
//
//                String pageName = toString(js.executeScript("return adobeDataLayer[" + i + "].page.name;"));
//                if (pageName.equals(expectedPageName)) {
//                    result += "Page name is valid: " + pageName + "\n";
//                } else {
//                    result += "Invalid page name at index " + i + ": " + pageName + "\n";
//                }
//
//                String pageSite = toString(js.executeScript("return adobeDataLayer[" + i + "].page.site;"));
//                if (pageSite.equals(expectedSite)) {
//                    result += "Page site is valid: " + pageSite + "\n";
//                } else {
//                    result += "Invalid page site at index " + i + ": " + pageSite + "\n";
//                }
//
//                String platformTechnology = toString(js.executeScript("return adobeDataLayer[" + i + "].platform.technology;"));
//                if (platformTechnology.equals(expectedPlatformTechnology)) {
//                    result += "Platform technology is valid: " + platformTechnology + "\n";
//                } else {
//                    result += "Invalid platform technology at index " + i + ": " + platformTechnology + "\n";
//                }
//
//                String language = toString(js.executeScript("return adobeDataLayer[" + i + "].user.language;"));
//                if (language.equals(expectedLanguage)) {
//                    result += "User language is valid: " + language + "\n";
//                } else {
//                    result += "Invalid user language at index " + i + ": " + language + "\n";
//                }
//
//                String zipCode = toString(js.executeScript("return adobeDataLayer[" + i + "].user.zipCode;"));
//                if (zipCode.equals(expectedZipCode)) {
//                    result += "User zipCode is valid: " + zipCode + "\n";
//                } else {
//                    result += "Invalid user zipCode at index " + i + ": " + zipCode + "\n";
//                }
//
//                String vehicleMake = toString(js.executeScript("return adobeDataLayer[" + i + "].vehicle.make;"));
//                if (vehicleMake.equals(expectedVehicleMake)) {
//                    result += "Vehicle make is valid: " + vehicleMake + "\n";
//                } else {
//                    result += "Invalid vehicle make at index " + i + ": " + vehicleMake + "\n";
//                }
//
//                String vehicleModel = toString(js.executeScript("return adobeDataLayer[" + i + "].vehicle.model;"));
//                if (vehicleModel.equals(expectedVehicleModel)) {
//                    result += "Vehicle model is valid: " + vehicleModel + "\n";
//                } else {
//                    result += "Invalid vehicle model at index " + i + ": " + vehicleModel + "\n";
//                }
//
//                String vehicleTrim = toString(js.executeScript("return adobeDataLayer[" + i + "].vehicle.trim;"));
//                if (vehicleTrim.equals(expectedVehicleTrim)) {
//                    result += "Vehicle trim is valid: " + vehicleTrim + "\n";
//                } else {
//                    result += "Invalid vehicle trim at index " + i + ": " + vehicleTrim + "\n";
//                }
//
//                String vehicleVin = toString(js.executeScript("return adobeDataLayer[" + i + "].vehicle.vin;"));
//                if (vehicleVin.equals(expectedVehicleVin)) {
//                    result += "Vehicle VIN is valid: " + vehicleVin + "\n";
//                } else {
//                    result += "Invalid vehicle VIN at index " + i + ": " + vehicleVin + "\n";
//                }
//
//                String vehicleYear = toString(js.executeScript("return adobeDataLayer[" + i + "].vehicle.year;"));
//                if (vehicleYear.equals(String.valueOf(expectedVehicleYear))) {
//                    result += "Vehicle year is valid: " + vehicleYear + "\n";
//                } else {
//                    result += "Invalid vehicle year at index " + i + ": " + vehicleYear + "\n";
//                }
//            }
//        } catch (Exception e) {
//            result = "Error during validation: " + e.getMessage();
//        }
//
//        return result;
//    }
//}
