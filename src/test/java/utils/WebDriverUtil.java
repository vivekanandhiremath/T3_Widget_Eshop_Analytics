package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverUtil {
    public static WebDriver driver;


    public static WebDriver initializeDriver(String responsivestate, String browser, boolean headlessMode) throws IllegalArgumentException {
        try {
            if (responsivestate.equalsIgnoreCase("desktop")) {
                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("-incognito");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("-private");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new FirefoxDriver(options);
                    driver.manage().window().maximize();
                } else if (browser.equalsIgnoreCase("edge")) {
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("-private");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new EdgeDriver(options);
                    driver.manage().window().maximize();
                } else {
                    throw new IllegalArgumentException("Unsupported browser for desktop: " + browser);
                }
            } else if (responsivestate.equalsIgnoreCase("tablet")) {
                if (browser.equalsIgnoreCase("chrome")) {
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPad Mini");

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.setExperimentalOption("args", new String[]{"--window-size=768,1024"});
                    options.addArguments("-incognito");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new ChromeDriver(options);
                } else if (browser.equalsIgnoreCase("edge")) {
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPad Mini");
                    EdgeOptions options = new EdgeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.setExperimentalOption("args", new String[]{"--window-size=768,1024"});
                    options.addArguments("-private");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new EdgeDriver(options);
                } else {
                    throw new IllegalArgumentException("Since Firefox doesn't support mobile emulator, not able to check as tablet responsive for browser: " + browser);
                }
            } else if (responsivestate.equalsIgnoreCase("mobile")) {
                if (browser.equalsIgnoreCase("chrome")) {
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPhone 14 Pro Max");

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.setExperimentalOption("args", new String[]{"--window-size=430,932"});
                    options.addArguments("-incognito");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new ChromeDriver(options);
                } else if (browser.equalsIgnoreCase("edge")) {
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "iPhone 14 Pro Max");
                    EdgeOptions options = new EdgeOptions();
                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    options.setExperimentalOption("args", new String[]{"--window-size=430,932"});
                    options.addArguments("-private");

                    if (headlessMode) {
                        options.addArguments("-headless");
                    }

                    driver = new EdgeDriver(options);
                } else {
                    throw new IllegalArgumentException("Since Firefox doesn't support mobile emulator, not able to check as mobile responsive for browser: " + browser);
                }
            } else {
                throw new IllegalArgumentException("Unsupported responsive state: " + responsivestate);
            }
        } catch (Exception e) {
            System.err.println("Error occurred while initializing WebDriver: " + e.getMessage());
            throw e;
        }

        return driver;
    }

    public static void quitDriver(WebDriver driver) {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("Error occurred while quitting WebDriver: " + e.getMessage());
        }
    }
}
