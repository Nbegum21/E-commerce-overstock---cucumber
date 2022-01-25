package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.PurchaseOutDoorItem;


public class PurchaseOutDoor_step {

    private static final Logger LOGGER= LogManager.getLogger(WallDecor_step.class);
    WebDriver driver = Hooks.driver;
    @And("^a user click on outdoor option for purchase garden Accents  items$")
    public void userClickOnSaleAndDeals() {
        new PurchaseOutDoorItem(driver)
                .userClickONOutDoor()
                .userClickOnCGardenAccent();
    }

    @And("^user select a item from garden accents page$")
    public void userSelectClearanceItem() {
        new PurchaseOutDoorItem(driver)
                .userSelectItemFromClearanceItm();
    }

    @And("^user able to added the item to cart from product page$")
    public void userAddedThItemToCart() {
        new PurchaseOutDoorItem(driver)
                .userSelectColor()
                .userAddedTheItemToCart();
    }


    @Then("^user successfully purchased the clearance item form the cart$")
    public void userSuccessfullyPurchased() {
       new PurchaseOutDoorItem(driver)
               .userSuccessfullyCheckOutTheItem();
    }

}
