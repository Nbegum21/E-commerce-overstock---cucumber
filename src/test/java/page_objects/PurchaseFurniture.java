package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PurchaseFurniture extends NavigatorBar {

    private static final By SearchOption = By.xpath("//*[@id=\"ostk-search-combobox\"]/input");
    private static final By ClickSearchButton = By.xpath("//button[@aria-label='search']//*[name()='svg']");
    private static final By ClickedTvStand = By.xpath("(//img[@alt='Strick & Bolton Amsden Electric Fireplace TV Stand'])[1]");
    private static final By SelectColor = By.xpath("//button[@title='White']//div[@class='cl-image-chip-image']");
    private static final By AddToCart = By.xpath("(//button[@class='css-1iwgr1p e1ndcgvg6'])[1]");
    private static final By CheckOut = By.xpath("//a[@id='stationaryButtonDesktop']");

    private static final Logger LOGGER = LogManager.getLogger(PurchaseFurniture.class);

    public PurchaseFurniture(WebDriver driver) {
        super(driver);
    }


    public PurchaseFurniture userSearchForTvStand(String value) {
        ActOn.element(driver, SearchOption).setValue("Fireplace tv stands");
        LOGGER.debug("user searching for fireplace TV stand from search Bar" + value);
        return this;
    }

    public PurchaseFurniture userClickedOnSearchButton() {
        ActOn.element(driver, ClickSearchButton).click();
        LOGGER.debug("user clicked search button for fireplace TV stand ");
        return this;
    }
    public PurchaseFurniture userClickedOnSelectItem() {
        ActOn.element(driver, ClickedTvStand).click();
        LOGGER.debug("user clicked on selected item for purchase");
        return this;
    }
    public PurchaseFurniture userSelectColorOfTehItem() {
        String originalWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.findElement(SelectColor).click();
        return this;
    }


    public PurchaseFurniture userAddedTheItemToTheCart() {;
        ActOn.element(driver,AddToCart).click();
        LOGGER.debug("the user added the Tv stand to the cart with the preferred configuration for the purchase");
        return this;

        }
    public  PurchaseFurniture userSuccessfullyCheckOutTheItem() {
        boolean validateCheckOutPage = driver.findElement(CheckOut).isDisplayed();
         Assert.assertTrue("User successfully  checkout the item", validateCheckOutPage);
        LOGGER.debug("user successfully checkout the item from the cart");
        return this;

    }


    }




