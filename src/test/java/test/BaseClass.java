package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.AdobeDataLayerValidator;
import utils.WebDriverUtil;

public class BaseClass {
    protected WebDriver driver;
    protected AdobeDataLayerValidator validator;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtil.initializeDriver();

        validator = new AdobeDataLayerValidator((JavascriptExecutor) driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtil.quitDriver(driver);
    }
}
