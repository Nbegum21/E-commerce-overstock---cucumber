package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.WallDecorItem;


public class WallDecor_step {

    private static final Logger LOGGER= LogManager.getLogger(WallDecor_step.class);
    WebDriver driver = Hooks.driver;

    @When("^a user searching for Wall Decor items$")
    public void  SearchBar() {
        new WallDecorItem(driver)
                .SearchBarWithItem("Wall Decor")
                .userClickOnSearchButton();
    }
        @And("^user select a Metal 36.5\" Wall Decor, Multi item from the searching result$")
        public void  SelectSearchItem() {
            new WallDecorItem(driver)
                    .userClickedOnItem();
    }

    @And("^user add the item  to the cart from the product page$")
    public void userLandedToProductPage() {
        new WallDecorItem(driver)
                .userClickOnAddToCartOption();
    }

    @Then("^user able to checkout successfully  from the cart$")
    public void userAddTheItemToTheCart() {
        new WallDecorItem(driver)
                .SuccessfullyCheckOutFromTheCart();
    }
}
