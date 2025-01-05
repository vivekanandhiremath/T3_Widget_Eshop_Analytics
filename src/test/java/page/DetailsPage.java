package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;

public class DetailsPage extends BasePage {
    @FindBy(xpath = "//button[.=' Test Drive ']")
    private WebElement testDriveButton;


    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTestDrive() {
        utils.clickOnElement(testDriveButton, EXPLICIT_WAIT_IN_SECONDS);
    }

}
