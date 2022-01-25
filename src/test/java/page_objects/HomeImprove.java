package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeImprove extends NavigatorBar{
    private static final By SearchBaR = By.xpath("//*[@id=\"ostk-search-combobox\"]/input");
    private static final By clickSearchButton = By.xpath("//button[@aria-label='search']");
    private static final By ClickItem = By.xpath("//img[@alt='12000 BTU 3-in-1 Portable Air Conditioner with Remote Control']");;
    private static final By ClickAddToCart =By.xpath("(//button[@class='os-btn-cl btn-cl-primary btn-cl-lg _1zbsAY _23k44-'])[1]");
    private static final By CheckOutFromTheCart = By.xpath("(//button[@class='os-btn-cl btn-cl-primary btn-cl-lg _1zbsAY _23k44-'])[1]");

    private static final Logger LOGGER = LogManager.getLogger(HomeImprove.class);

    public HomeImprove(WebDriver driver) {

        super(driver);
    }

    public HomeImprove userEnterSearchBar(String value) {
        ActOn.element(driver,SearchBaR).setValue("Portable Air Conditioners");
        LOGGER.debug(" user search for purchase a Portable Air Conditioners");
        return this;
    }
    public HomeImprove clickSearchButton() {
        ActOn.element(driver,clickSearchButton).click();
        LOGGER.debug("User clicked on Search button for searching item");
        return this;
    }

    public HomeImprove userClickOnItem() {
        ActOn.element(driver, ClickItem).click();
        LOGGER.info("User clicked on Movado Women's 0605247 'Kara' Stainless Steel item");
        return this;
    }

    public HomeImprove userAddedItemToThe() {
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


    public HomeImprove userIteCheckOut() {
        boolean displayed = driver.findElement(CheckOutFromTheCart).isDisplayed();
        Assert.assertTrue("the expected element does not exit",displayed);
        LOGGER.debug("user landed checkout the item from the cart");
        return this;
    }
}
