package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovadoWatchPurchase extends NavigatorBar {
    private static final By SearchBar = By.xpath("//*[@id=\"ostk-search-combobox\"]/input");
    private static final By clickSearchButton = By.xpath("//button[@aria-label='search']");
    private static final By ClickSelectItem = By.xpath("//img[@alt=\"Movado Women's 0605247 'Kara' Stainless Steel Watch\"]");
   // private static final By LandedProductPage = By.xpath("(//div)[291]");
  // private static final By ProductPage = By.id("hd");
    private static final By ClickAddToCart =By.xpath("(//button[@class='css-1iwgr1p e1ndcgvg6'])[1]");
    private static final By CheckOutFromTheCart = By.xpath("//*[@id=\"stationaryButtonDesktop\"]");
   // private static final By roductPage = By.id("__next");
  //  private static final By SelectColour = By.xpath("(//div[@class='cl-image-chip-image'])[2]");
   // private static final By SelectQuantity = By.xpath("//select[@aria-label='quantity']");


    private static final Logger LOGGER = LogManager.getLogger(MovadoWatchPurchase.class);

    public MovadoWatchPurchase(WebDriver driver) {

        super(driver);
    }

    public MovadoWatchPurchase SearchBar(String value) {
        ActOn.element(driver,SearchBar).setValue("movado womens watch");
        LOGGER.info(" user search for purchase a  Movado Womens Watch");
        return this;
    }
    public MovadoWatchPurchase clickSearchButton() {
        ActOn.element(driver,clickSearchButton).click();
        LOGGER.info("User clicked on Search button for searching item");
        return this;
    }

    public MovadoWatchPurchase clickSelectItem() {
        ActOn.element(driver,ClickSelectItem).click();
        LOGGER.info("User clicked on Movado Women's 0605247 'Kara' Stainless Steel item");
        return this;
    }

   public MovadoWatchPurchase userLandedTpProductPage() {
       String originalWindow = driver.getWindowHandle();

       for (String windowHandle : driver.getWindowHandles()) {
           if (!originalWindow.contentEquals(windowHandle)) {
               driver.switchTo().window(windowHandle);
               break;
           }
       }
        driver.findElement(ClickAddToCart).click();
       return this;
   }


    public MovadoWatchPurchase userCheckOutTheItemSuccessfully() {
        boolean displayed = driver.findElement(CheckOutFromTheCart).isDisplayed();
        Assert.assertTrue("the movado watch successfully checkout",displayed);
        LOGGER.debug("user checkout the item from the cart");
        return this;
    }
}



