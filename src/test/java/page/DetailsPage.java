package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;
import static utils.CommonUtils.THREAD_SLEEP_TIME_MILLIS;

public class DetailsPage extends BasePage {
    @FindBy(xpath = "//button[.=' Test Drive ']")
    private WebElement testDriveButton;


    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTestDrive() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(testDriveButton, EXPLICIT_WAIT_IN_SECONDS);
    }

}
