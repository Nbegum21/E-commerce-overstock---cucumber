package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginPurchase extends NavigatorBar{
    private static final By Account = By.className("UserDropDowns_icon_06");
    private static final By SignIn = By.xpath("(//div[@class='Account_title_84'])[1]");
    private static final By InputEmailAddress = By.id("login-email");
    private static final By InputPassword = By.name("password");
    private static final By SingInBtn = By.xpath("//*[@id=\"login-form\"]/button");
    private static final By AccountHomepage = By.xpath("(//div)[52]");
    private static final By invalidPassword = By.xpath("//iframe[@id='loginIframe']");

    private static final Logger LOGGER = LogManager.getLogger(LoginPurchase.class);

    public LoginPurchase(WebDriver driver) {
        super(driver);
    }

    public LoginPurchase mouseHoverToAccountOption() {
        ActOn.element(driver, Account).mouseHover();
        LOGGER.info("User mouse hover to account option");
        return this;
    }

    public LoginPurchase clickOnSignInOption() {
        ActOn.element(driver, SignIn).click();
        LOGGER.info("User clicked on sign in button");
        return this;
    }
    public LoginPurchase waitForElementToBeVisible() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("loginIframe");
        return this;
    }

    public LoginPurchase userEnterEmailAddress(String email,String password) {
        ActOn.element(driver,InputEmailAddress).setValue(email);
        ActOn.element(driver, InputPassword).setValue(password);
        LOGGER.info("User has entered email");
        return this;

    }

    public LoginPurchase userClickOnLoginButtonUponEnteringCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : data) {
            ActOn.element(driver, InputEmailAddress).setValue(cells.get("email"));
            ActOn.element(driver, InputPassword).setValue(cells.get("password"));
            LOGGER.info("User has entered credentials");

            ActOn.element(driver, SingInBtn).click();
            LOGGER.info("User clicked on login button");
            return this;
        }
        ActOn.element(driver, SingInBtn).click();
        return null;
    }

        public LoginPurchase clickOnLogin() {
        ActOn.element(driver,SingInBtn).click();
        driver.switchTo().defaultContent();
        LOGGER.info("User clicked on sing in button");
        return this;
    }

    public LoginPurchase userNavigateToHomePage() {
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        AssertThat.elementAssertions(driver,AccountHomepage).elementIsDisplayed();
        LOGGER.info("User is navigated to check out page");
        return this;
    }

    public LoginPurchase validateUserIsFailedToSinIn() {
       // driver.switchTo().frame("loginIframe");
        AssertThat.elementAssertions(driver,invalidPassword).elementIsDisplayed();
        LOGGER.info("logger is still ON THE login page");
        return this;
    }
}
