package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;

public class HomePage extends BasePage {


    @FindBy(xpath = "(//button[@role='Close'])[2]")
    private WebElement leadFormCloseIcon;

    @FindBy(xpath = "(//span[.='Submit'])[1]")
    private WebElement submitSideMenu;
    @FindBy(xpath = "(//button[@id='expressBtn'])[1]")
    private WebElement usedVehiclePaymentOptions;
    @FindBy(xpath = "(//span[.='Accessories'])[1]")
    private WebElement accessoriesSideMenu;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewVehicles() {
        utils.clickOnElement(usedVehiclePaymentOptions, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnLeadFormCloseIcon() {
        utils.clickOnElement(leadFormCloseIcon, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnLeadSubmitSideMenu() {
        utils.clickOnElement(submitSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnLeadAccessoriesSideMenu() {
        utils.clickOnElement(accessoriesSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }
}
