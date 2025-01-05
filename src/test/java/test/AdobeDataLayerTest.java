//package test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import utils.AdobeDataLayerValidator;
//import utils.WebDriverUtil;
//
//import java.time.Duration;
//
//public class AdobeDataLayerTest {
//
//    private WebDriver driver;
//    private AdobeDataLayerValidator validator;
//
//    @BeforeClass
//    public void setUp() {
//        driver = WebDriverUtil.initializeDriver();
//        validator = new AdobeDataLayerValidator((JavascriptExecutor) driver);
//    }
//
//    @Test
//    public void validateAdobeDataLayer() {
//        driver.get("https://old-dealeradmin.eshopdemo.net/widget/redesign");
//
//        // Wait for the button and click it
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='expressBtn'])[1]"))).click();
//
//        // Sleep to wait for data layer updates (adjust if needed)
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        // Fetch Adobe Data Layer and validate it
//        int dataLayerSize = validator.getDataLayerSize();
//        int lastIndex = dataLayerSize - 1;
//
//        String[] results = {
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].event;", "page-load", "Event"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].dealer.code;", "44990", "Dealer Code"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].page.name;", "build-your-deal:vehicle-details", "Page Name"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].page.site;", "dealer", "Page Site"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].platform.technology;", "carzato", "Platform Technology"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].user.language;", "en-US", "User Language"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].user.zipCode;", "77450", "User Zip Code"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].vehicle.make;", "dodge", "Vehicle Make"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].vehicle.model;", "charger", "Vehicle Model"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].vehicle.trim;", "sxt", "Vehicle Trim"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].vehicle.vin;", "2c3cdxbgxph656415", "Vehicle VIN"),
//                validator.validateField("return adobeDataLayer[" + lastIndex + "].vehicle.year;", "2023", "Vehicle Year")
//        };
//
//        // Print results
//        for (String result : results) {
//            System.out.println(result);
//        }
//    }
//
//    @AfterClass
//    public void tearDown() {
//        WebDriverUtil.quitDriver(driver);
//    }
//}
