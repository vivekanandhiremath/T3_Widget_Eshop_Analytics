package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;

public class HomePage extends BasePage {


    @FindBy(xpath = "//img[@alt='delivery icon']")
    private WebElement submitSideMenu;
    @FindBy(xpath = "(//button[@role='Close'])[2]")
    private WebElement leadFormCloseIcon;
    @FindBy(xpath = "(//button[@id='expressBtn'])[1]")
    private WebElement usedVehiclePaymentOptions;
    @FindBy(xpath = "//div[@class='widget_e-shop']")
    private WebElement eshopLogo;
    @FindBy(xpath = "//button[@role='Close']//*[name()='svg']")
    private WebElement topNavBarCloseIcon;
    @FindBy(xpath = "//img[@src='../assets/images/icons/trade_in.svg']")
    private WebElement tradInSideMenu;
    @FindBy(xpath = "//img[@alt='Service Protection']")
    private WebElement protectionSideMenu;
    @FindBy(xpath = "//img[@alt='accessories icon']")
    private WebElement accessoriessideMenu;
    @FindBy(xpath = "//span[.='Apply for Credit']")
    private WebElement applyForCreditisideMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewVehicles() {
        utils.clickOnElement(usedVehiclePaymentOptions, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnLeadFormCloseIcon() {
        utils.clickOnElement(leadFormCloseIcon, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnSubmitSideMenu() {
        utils.clickOnElement(submitSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnAccessoriesSideMenu() {
        utils.clickOnElement(accessoriessideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnEshopLogo() {
        utils.clickOnElement(eshopLogo, EXPLICIT_WAIT_IN_SECONDS);

    }

    public void clickOnTopNavBarClose() {
        utils.clickOnElement(topNavBarCloseIcon, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnTradeIn() {
        utils.clickOnElement(tradInSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnProtection() {
        utils.clickOnElement(protectionSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnApplyForCredit() {
        utils.clickOnElement(applyForCreditisideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

}
