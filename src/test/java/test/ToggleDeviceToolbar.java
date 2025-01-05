package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ToggleDeviceToolbar {
    public static void main(String[] args) {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "iPad Mini");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.setExperimentalOption("args", new String[]{"--window-size=768,1024"});
        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get("https://old-dealeradmin.eshopdemo.net/widget/redesign");


    }
}
