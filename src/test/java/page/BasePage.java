package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class BasePage {
    WebDriver driver;
    ElementUtils utils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new ElementUtils(driver);
    }

}
