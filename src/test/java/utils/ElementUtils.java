package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;

    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private WebElement waitForAnElement(WebElement element, long durationinsec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinsec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(WebElement element, long durationinsec) {
        WebElement webelement = waitForAnElement(element, durationinsec);
        webelement.click();

    }

}
