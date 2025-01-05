package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtil {

    public static WebDriver initializeDriver() {
//        Map<String, String> mobileEmulation = new HashMap<String, String>();
//        mobileEmulation.put("deviceName", "iPad Mini");
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);
//        options.setExperimentalOption("args", new String[]{"--window-size=768,1024"});
//        WebDriver driver = new ChromeDriver(options);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
