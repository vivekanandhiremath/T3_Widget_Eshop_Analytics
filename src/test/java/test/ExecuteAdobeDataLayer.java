//package test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class ExecuteAdobeDataLayer {
//    public static void main(String[] args) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("-incognito");
//        WebDriver driver = new ChromeDriver(options);
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
//            int dataLayerSize = ((Long) js.executeScript("return adobeDataLayer.length;")).intValue();
//
//            int lastIndex = dataLayerSize - 1;
//
//            String event = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].event;"));
//            if (event.equals(expectedEvent)) {
//                result += "Event is valid: " + event + "\n";
//            } else {
//                result += "Invalid event at last index: " + event + "\n";
//            }
//
//            String dealerCode = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].dealer.code;"));
//            if (dealerCode.equals(expectedDealerCode)) {
//                result += "Dealer code is valid: " + dealerCode + "\n";
//            } else {
//                result += "Invalid dealer code at last index: " + dealerCode + "\n";
//            }
//
//            String pageName = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].page.name;"));
//            if (pageName.equals(expectedPageName)) {
//                result += "Page name is valid: " + pageName + "\n";
//            } else {
//                result += "Invalid page name at last index: " + pageName + "\n";
//            }
//
//            String pageSite = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].page.site;"));
//            if (pageSite.equals(expectedSite)) {
//                result += "Page site is valid: " + pageSite + "\n";
//            } else {
//                result += "Invalid page site at last index: " + pageSite + "\n";
//            }
//
//            String platformTechnology = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].platform.technology;"));
//            if (platformTechnology.equals(expectedPlatformTechnology)) {
//                result += "Platform technology is valid: " + platformTechnology + "\n";
//            } else {
//                result += "Invalid platform technology at last index: " + platformTechnology + "\n";
//            }
//
//            String language = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].user.language;"));
//            if (language.equals(expectedLanguage)) {
//                result += "User language is valid: " + language + "\n";
//            } else {
//                result += "Invalid user language at last index: " + language + "\n";
//            }
//
//            String zipCode = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].user.zipCode;"));
//            if (zipCode.equals(expectedZipCode)) {
//                result += "User zipCode is valid: " + zipCode + "\n";
//            } else {
//                result += "Invalid user zipCode at last index: " + zipCode + "\n";
//            }
//
//            String vehicleMake = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].vehicle.make;"));
//            if (vehicleMake.equals(expectedVehicleMake)) {
//                result += "Vehicle make is valid: " + vehicleMake + "\n";
//            } else {
//                result += "Invalid vehicle make at last index: " + vehicleMake + "\n";
//            }
//
//            String vehicleModel = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].vehicle.model;"));
//            if (vehicleModel.equals(expectedVehicleModel)) {
//                result += "Vehicle model is valid: " + vehicleModel + "\n";
//            } else {
//                result += "Invalid vehicle model at last index: " + vehicleModel + "\n";
//            }
//
//            String vehicleTrim = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].vehicle.trim;"));
//            if (vehicleTrim.equals(expectedVehicleTrim)) {
//                result += "Vehicle trim is valid: " + vehicleTrim + "\n";
//            } else {
//                result += "Invalid vehicle trim at last index: " + vehicleTrim + "\n";
//            }
//
//            String vehicleVin = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].vehicle.vin;"));
//            if (vehicleVin.equals(expectedVehicleVin)) {
//                result += "Vehicle VIN is valid: " + vehicleVin + "\n";
//            } else {
//                result += "Invalid vehicle VIN at last index: " + vehicleVin + "\n";
//            }
//
//            String vehicleYear = toString(js.executeScript("return adobeDataLayer[" + lastIndex + "].vehicle.year;"));
//            if (vehicleYear.equals(String.valueOf(expectedVehicleYear))) {
//                result += "Vehicle year is valid: " + vehicleYear + "\n";
//            } else {
//                result += "Invalid vehicle year at last index: " + vehicleYear + "\n";
//            }
//
//        } catch (Exception e) {
//            result = "Error during validation: " + e.getMessage();
//        }
//
//        return result;
//    }
//}
