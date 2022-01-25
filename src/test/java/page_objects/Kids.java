package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Kids extends NavigatorBar{
    private static final By KidsButton = By.xpath("//*[@id=\"TopNav\"]/div[1]/div[10]/a");
    private static final By KidsGift = By.xpath("//span[normalize-space()='Gifts for Kids']");
    private static final By KidsStorage = By.xpath("//img[@alt='UTEX Kids Dress up Storage with Mirror and Storage Bin,Kids Armoire Dresser,Costume Closet,Pretend Storage Closet for Kids']");
    private static final By SelectColor = By.xpath("//button[@title='Grey / Pink']//div[@class='cl-image-chip-image']");
    private static final By AddCart = By.xpath("(//button[@class='css-1iwgr1p e1ndcgvg6'])[1]");
    private static final By CheckOut = By.xpath("//a[@id='stationaryButtonDesktop']");


    private static final Logger LOGGER = LogManager.getLogger(Kids.class);

    public Kids(WebDriver driver) {

        super(driver);
    }


    public Kids ClickOnKidsButton(){
        LOGGER.debug("user click on Kids Button");
        ActOn.element(driver, KidsButton).click();
        return this;
    }
    public Kids ClickOnKidsGiftButton () {
        LOGGER.debug("user click on Kids Gift Button");
        ActOn.element(driver, KidsGift).click();
        return this;
    }
    public Kids SelectColor() {
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


    public Kids ClickOnKidsStorageButton () {
        LOGGER.debug("user click on Kids Storage Button");
        ActOn.element(driver, KidsStorage).click();
        return this;
    }
    public Kids ClickOnAddCartButton () {
        LOGGER.debug("user click on Add Cart Button");
        ActOn.element(driver, AddCart).click();
        return this;
    }
    public Kids ShoppingCartPageDisplayed () {
        LOGGER.debug("ValidateKidsStoragePage");
        boolean ValidatedShoppingCartPage = driver.findElement(CheckOut).isDisplayed();
        Assert.assertTrue("AirPods page name is Displayed on the page",ValidatedShoppingCartPage);
        return this;
    }
}

