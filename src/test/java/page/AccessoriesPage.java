package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;
import static utils.CommonUtils.THREAD_SLEEP_TIME_MILLIS;

public class AccessoriesPage extends BasePage {


    @FindBy(xpath = "(//button[@id='expressBtn'])[1]")
    private WebElement usedVehiclePaymentOptions;


    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnNewVehicles() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(usedVehiclePaymentOptions, EXPLICIT_WAIT_IN_SECONDS);
    }
}
