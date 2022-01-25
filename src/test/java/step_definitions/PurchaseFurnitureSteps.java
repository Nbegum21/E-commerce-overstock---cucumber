package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.PurchaseFurniture;

public class PurchaseFurnitureSteps {

    private static final Logger LOGGER = LogManager.getLogger(PurchaseFurnitureSteps.class);
    WebDriver driver = Hooks.driver;

    @When("^a user searching for fireplace TV stand from search bar$")
    public void userSearchForTvStand() {
        new PurchaseFurniture(driver)
                .userSearchForTvStand("Fireplace tv stands")
                .userClickedOnSearchButton();
        LOGGER.info("a user searching for fireplace TV stand from search bar");
    }

    @And("^the user clicked Strick & Bolton Amsden Electric Fireplace TV Stand from the search result$")
    public void userClickOnSelectedYvStand() {
        new PurchaseFurniture(driver)
                .userClickedOnSelectItem();

    }

    @And("^the user add the Tv stand to the cart with the preferred configuration for the purchase$")
    public void userAddTheTvStandToTheCart() {
        new PurchaseFurniture(driver)
                .userSelectColorOfTehItem()
                .userAddedTheItemToTheCart();
        LOGGER.info("the user add the Tv stand to the cart with the preferred configuration for the purchase");
    }

    @Then("^the tv stand is purchased successfully$")
    public void TvStandIsPurchasedSuccessfully() {
        new PurchaseFurniture(driver)
                .userSuccessfullyCheckOutTheItem();
        LOGGER.info("the tv stand is purchased successfully");
    }
}
