package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.HomeImprove;


public class HomeImprove_step {
    private static final Logger LOGGER= LogManager.getLogger(KidsSteps.class);
    WebDriver driver = Hooks.driver;

    @When("^a user searching for Portable Air Conditioners click on search button$")
    public void SearchItemFromSearBar(){
        new HomeImprove(driver)
                .userEnterSearchBar("Portable Air Conditioners")
                .clickSearchButton();

    }
    @And("^User click on  item from searching product page$")
    public void ClickOnAirConditionItem(){
        new HomeImprove(driver)
                .userClickOnItem();
    }
    @And("^user able to click on add to cart button from selecting item$")
    public void ClickOnAddCartButton(){
        new HomeImprove(driver)
                .userAddedItemToThe();
    }
    @Then("^user the item purchase successfully$")
    public void ClickOnCheckOut(){
        new HomeImprove(driver)
                .userIteCheckOut();
    }

}
