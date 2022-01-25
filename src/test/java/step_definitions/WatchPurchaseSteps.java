package step_definitions;

import Utilities.ReadConfigFiles;
import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.MovadoWatchPurchase;


public class WatchPurchaseSteps {

    private static final By EnableDiscountAndShoppingAlert = By.id("notification_deny");

    private static final Logger LOGGER = LogManager.getLogger(WatchPurchaseSteps.class);
    WebDriver driver= Hooks.driver;


    @Given("^a user is on the Home Page$")
    public void navigateToLHomePage() {
      String url = ReadConfigFiles.getPropertyValues("OverstockAppUrl");
        ActOn.browser(driver).openBrowser(url);
        driver.manage().window().maximize();
      LOGGER.info("a user is on the Home Page");
    }

 @And("^click on No Thanks$")
    public void clickOnNoThanks() {
     ActOn.element(driver,EnableDiscountAndShoppingAlert).click();
     LOGGER.info("User clicked on No Thanks button");
  }

    @When("^a user search for a Movado Womens Watch from searching bar$")
    public void userSearchWithItem() {
        new MovadoWatchPurchase(driver)
                .SearchBar("Movado Womens Watch")
                .clickSearchButton();
    }

    @And("^user clicked on item from searching result$")
    public void userClickedOnSelectedItem() {
        new MovadoWatchPurchase(driver)
                .clickSelectItem();

    }

    @And("^user add the item  to the cart for purchase movado watch$")
    public void userAddTheItemToTheCart()  {
        new MovadoWatchPurchase(driver)
                .userLandedTpProductPage();
  }

    @Then("^user successfully checkout the item from the cart$")
    public void userSuccessfullyCheckOut() {
        new MovadoWatchPurchase(driver)
                .userCheckOutTheItemSuccessfully();
    }
}