package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Kids;


public class KidsSteps {
    private static final Logger LOGGER= LogManager.getLogger(KidsSteps.class);
    WebDriver driver = Hooks.driver;

    @When("^user able to click on Kids button$")
    public void ClickOnKidsButton(){
        new Kids(driver)
                .ClickOnKidsButton();

    }
    @And("^user able to click on gift for kids and able to select the kids storage$")
    public void ClickOnGiftButton(){
        new Kids(driver)
                .ClickOnKidsGiftButton()
                .ClickOnKidsStorageButton();
    }
    @And("^user able to click on add to cart button$")
    public void ClickOnAddCartButton(){
        new Kids(driver)
                .SelectColor()
                .ClickOnAddCartButton();
    }
    @Then("^user landed on check out page$")
    public void ClickOnCheckOut(){
        new Kids(driver)
                .ShoppingCartPageDisplayed();
    }


}
