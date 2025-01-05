package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.AdobeDataLayerValidator;
import utils.ReadProperty;
import utils.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

import static utils.WebDriverUtil.quitDriver;

public class BaseClass {
    protected WebDriver driver;
    protected AdobeDataLayerValidator validator;
    protected List<String> assertionFailures;
    protected ReadProperty read = new ReadProperty("browser.properties");

    @BeforeClass
    public void setUp() {
        String responsivestate = read.getProperty("responsivestate");
        String browser = read.getProperty("browser");
        boolean headlessMode = Boolean.parseBoolean(read.getProperty("headlessMode"));


        driver = WebDriverUtil.initializeDriver(responsivestate, browser, headlessMode);

        validator = new AdobeDataLayerValidator((JavascriptExecutor) driver);
        assertionFailures = new ArrayList<>();
    }

    @AfterClass
    public void tearDown() {

        quitDriver();
        if (!assertionFailures.isEmpty()) {
            assertionFailures.forEach(System.err::println);
            assert false : "There were assertion failures!";
        }

    }

    public void collectAssertionFailure(String failureMessage) {
        assertionFailures.add(failureMessage);
    }
}
