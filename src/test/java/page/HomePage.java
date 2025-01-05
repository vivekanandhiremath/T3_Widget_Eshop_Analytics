package page;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

import static utils.CommonUtils.EXPLICIT_WAIT_IN_SECONDS;
import static utils.CommonUtils.THREAD_SLEEP_TIME_MILLIS;

public class HomePage extends BasePage {


    @FindBy(xpath = "//img[@alt='delivery icon']")
    private WebElement submitSideMenu;

    @FindBy(xpath = "(//button[@role='Close'])[2]")
    private WebElement leadFormCloseIcon;

    @FindBy(xpath = "(//button[@id='expressBtn'])[2]")
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
    @FindBy(xpath = "(//span[.='Details'])[1]")
    private WebElement detailsSideMenu;
    @FindBy(xpath = "//input[@placeholder='firstName']")
    private WebElement firstnametextfield;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDetailsSideMenu() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(detailsSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnNewVehicles() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(usedVehiclePaymentOptions, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void handelLeadForm(String firstname) {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);

        try {
            if (leadFormCloseIcon.isDisplayed()) {
                System.out.println(leadFormCloseIcon.isDisplayed());
                utils.clickOnElement(leadFormCloseIcon, EXPLICIT_WAIT_IN_SECONDS);
            }
        } catch (ElementNotInteractableException e) {
            System.out.println("executing catch");
            utils.typeIntoField(firstnametextfield, firstname, EXPLICIT_WAIT_IN_SECONDS);
        }
    }

    public void clickOnSubmitSideMenu() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(submitSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnAccessoriesSideMenu() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(accessoriessideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnEshopLogo() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(eshopLogo, EXPLICIT_WAIT_IN_SECONDS);

    }

    public void clickOnTopNavBarClose() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(topNavBarCloseIcon, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnTradeIn() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(tradInSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnProtection() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(protectionSideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnApplyForCredit() {
        ElementUtils.sleep(THREAD_SLEEP_TIME_MILLIS);
        utils.clickOnElement(applyForCreditisideMenu, EXPLICIT_WAIT_IN_SECONDS);
    }


}
