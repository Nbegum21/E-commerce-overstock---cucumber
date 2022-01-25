package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WallDecorItem extends NavigatorBar {
    private static final By SearchBar = By.xpath("//input[@placeholder='Search... everything you find ships for free']");
    private static final By ClickedSearchButton = By.xpath("//button[@aria-label='search']//*[name()='svg']");
    private static final By SelectItem = By.xpath("//img[@alt='Metal 36.5\" Wall Decor, Multi,Wb']");
    private static final By AddToCart = By.xpath("(//button[@class='css-1iwgr1p e1ndcgvg6'])[1]");
    private static final By CheckOut = By.xpath("//a[@data-cy='totals-checkout-button-desktop']");

    private static final Logger LOGGER = LogManager.getLogger(WallDecorItem.class);

    public WallDecorItem(WebDriver driver) {
        super(driver);
    }

    public WallDecorItem SearchBarWithItem(String value) {
        ActOn.element(driver, SearchBar).setValue("Wall Decor");
        LOGGER.info("user searching for item wall decor from search bar");
        return this;
    }
    public WallDecorItem userClickOnSearchButton() {
        ActOn.element(driver,ClickedSearchButton).click();
        LOGGER.info("User clicked on Search button for wall decor item");
        return this;
    }

    public WallDecorItem userClickedOnItem() {
        ActOn.element(driver,SelectItem).click();
        LOGGER.info("User clicked on Metal 36.5\" Wall Decor, Multi item");
        return this;
    }


    public WallDecorItem userClickOnAddToCartOption() {
            String originalWindow = driver.getWindowHandle();

            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            driver.findElement(AddToCart).click();
            return this;
        }


    public WallDecorItem SuccessfullyCheckOutFromTheCart() {
        boolean validateCheckOutPage = driver.findElement(CheckOut).isDisplayed();
        Assert.assertTrue("User validated the page from the checkout page", validateCheckOutPage);
        LOGGER.info("user Successfully checkOut  from the cart item item");
        return this;
    }
}



