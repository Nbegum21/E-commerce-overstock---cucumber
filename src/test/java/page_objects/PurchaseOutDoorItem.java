package page_objects;


import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PurchaseOutDoorItem extends NavigatorBar{
    private static final By ClickOutDoor= By.xpath("//a[normalize-space()='Outdoor']");
    private static final  By ClickOnGardenAccents = By.xpath("(//a[@class='leftNav_tierOneLeftnavLink__6h-EH'][normalize-space()='Garden Accents'])[1]");
    private static final By  SelectItem= By.xpath("//img[@alt='Glitzhome Farmhouse Wooden Metal Lanterns Set of Two']");
    private static final By SelectColor= By.xpath("//button[@title='White']//div[@class='cl-image-chip-image']");
    private static final By AddedToCart = By.xpath("//*[@id=\"__next\"]/div/main/div/div[2]/section[2]/div[7]/div[2]/div/div/button[2]");
    private static final By CheckOut = By.xpath("//a[@data-cy='totals-checkout-button-desktop']");


    private static final Logger LOGGER = LogManager.getLogger(PurchaseOutDoorItem.class);

    public PurchaseOutDoorItem(WebDriver driver) {
        super(driver);
    }



    public PurchaseOutDoorItem userClickONOutDoor() {
        ActOn.element(driver,ClickOutDoor).click();
        LOGGER.debug("a user click on sale and deals option for clearance items");
        return this;
    }

    public PurchaseOutDoorItem userClickOnCGardenAccent() {
        ActOn.element(driver, ClickOnGardenAccents).click();
        LOGGER.debug("user clicked on clearance option from sale and deals");
        return this;
    }
    public PurchaseOutDoorItem userSelectItemFromClearanceItm() {
        ActOn.element(driver, SelectItem).click();
        LOGGER.debug("user selected item from clearance page");
        return this;
    }
    public PurchaseOutDoorItem userSelectColor() {
        String originalWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.findElement(SelectColor).click();
        LOGGER.debug("user selected color from product page");
        return this;
    }
    public PurchaseOutDoorItem userAddedTheItemToCart() {
        ActOn.element(driver,AddedToCart).click();
        LOGGER.debug("user added the item to cart");
        return this;
    }

    public PurchaseOutDoorItem userSuccessfullyCheckOutTheItem() {
        boolean validateCheckOutPage = driver.findElement(CheckOut).isDisplayed();
        Assert.assertTrue("User validated the page from the checkout page", validateCheckOutPage);
        LOGGER.debug("user successfully checkout the item from the cart");
        return this;

    }

}
