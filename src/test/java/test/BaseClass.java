package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.AdobeDataLayerValidator;
import utils.WebDriverUtil;

import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    protected WebDriver driver;
    protected AdobeDataLayerValidator validator;
    protected List<String> assertionFailures;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtil.initializeDriver("desktop", "chrome");

        validator = new AdobeDataLayerValidator((JavascriptExecutor) driver);
        assertionFailures = new ArrayList<>();
    }

    @AfterClass
    public void tearDown() {

        WebDriverUtil.quitDriver(driver);
        if (!assertionFailures.isEmpty()) {
            assertionFailures.forEach(System.err::println);
            assert false : "There were assertion failures!";
        }

    }

    public void collectAssertionFailure(String failureMessage) {
        assertionFailures.add(failureMessage);
    }
}
