package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.LoginPurchase;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private static final By InputEmailAddress = By.id("login-email");
    private static final By InputPassword = By.id("login-password");
    private static final By SingInBtn = By.xpath("//*[@id=\"login-form\"]/button");
    private static final By invalidPassword = By.xpath("(//span[@class='input-error'])[1]");

    private static final Logger LOGGER= LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;


    @When("^user Mouse hover to account option and click sign in option$")
    public void mouseHoverToAccountOption() {
        new LoginPurchase(driver)
                .mouseHoverToAccountOption()
                        .clickOnSignInOption()
                .waitForElementToBeVisible();
    }
    @And("^user enter email\"(.+?)\" and password\"(.+?)\"$")
    public void userEnterValidCredentials(String email, String passsword) {
        ActOn.element(driver,InputEmailAddress).setValue("nbegum.realtor@gmail.com");
        ActOn.element(driver, InputPassword).setValue("Lovely1234");
        LOGGER.debug("User enter valid email" + email + passsword);
    }


    @When("^user click on login button upon entering credentials$")
    public void userClickOnLoginButtonUponEnteringCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String, String> cells:data) {
            ActOn.element(driver,InputEmailAddress).setValue(cells.get("email"));
            ActOn.element(driver,InputPassword).setValue(cells.get("password"));
            LOGGER.info("User has entered credentials");

            ActOn.element(driver,SingInBtn).click();
            LOGGER.info("User clicked on login button");
        }
    }

    @And("^user click on sign in Button$")
    public void ClickOnSigInButton() {
        new LoginPurchase(driver)
                .clickOnLogin();
    }

    @Then("^user is navigated to homepage page$")
    public void UserIsLoggedSuccessfully() {
      new LoginPurchase(driver)
              .userNavigateToHomePage();
    }
    @Then("^user is failed to sign in$")
    public void validateUserIsFailedToSignIn() {
        new LoginPurchase(driver)
                .validateUserIsFailedToSinIn();
    }
}


