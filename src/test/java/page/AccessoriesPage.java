package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;

public class AccessoriesPage extends BasePage {


    @FindBy(xpath = "(//button[@id='expressBtn'])[1]")
    private WebElement usedVehiclePaymentOptions;


    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnNewVehicles() {
        utils.clickOnElement(usedVehiclePaymentOptions, EXPLICIT_WAIT_IN_SECONDS);
    }
}
