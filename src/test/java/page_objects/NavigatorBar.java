package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorBar {
    private static final By SearchBar = By.xpath("//input[@placeholder='Search... everything you find ships for free']");
    private static final By SignIn = By.xpath("(//div[@class='Account_title_84'])[1]");
    private static final By SearchOption = By.xpath("//*[@id=\"ostk-search-combobox\"]/input");
    private static final By KidsButton = By.xpath("//*[@id=\"TopNav\"]/div[1]/div[10]/a");
    private static final By SalesAndDeals = By.xpath("(//a[normalize-space()='Sales & Deals'])[1]");
    private static final By ClickItem = By.xpath("//a[normalize-space()='Outdoor']");


    private static final Logger LOGGER = LogManager.getLogger(NavigatorBar.class);
    public WebDriver driver;

    public NavigatorBar(WebDriver driver) {
        this.driver = driver;
    }

    public MovadoWatchPurchase SearchBar(String value) {
        ActOn.element(driver, SearchBar).setValue("movado womens watch");
        LOGGER.info(" user search for purchase a  Movado Womens Watch");
        return (MovadoWatchPurchase) this;
    }


    public WallDecorItem SearchBarWithItem(String value) {
        ActOn.element(driver, SearchBar).setValue("Explore Popular Categories");
        LOGGER.info("user searching for item explore popular categories");
        return new WallDecorItem(driver);
    }


    public LoginPurchase clickOnSignInOption() {
        ActOn.element(driver, SignIn).click();
        LOGGER.info("User clicked on sign in button");
        return new LoginPurchase(driver);
    }

    public PurchaseFurniture userSearchForTvStand(String value) {
        ActOn.element(driver, SearchOption).setValue(value);
        LOGGER.info("user searching for TV stand from search button");
        return new PurchaseFurniture(driver);
    }

    public Kids NavigateToKidsButton(String value) {
        LOGGER.info("Navigate to kids button");
        ActOn.element(driver, KidsButton).setValue(value);
        return new Kids(driver);
    }

    public PurchaseOutDoorItem userClickONOutDoor() {
        ActOn.element(driver,SalesAndDeals ).click();
        LOGGER.debug("user click on Sales and deals option");
        return new PurchaseOutDoorItem(driver);
    }

    public HomeImprove userClickOnItem() {
        ActOn.element(driver, ClickItem).click();
        LOGGER.info("User clicked on Movado Women's 0605247 'Kara' Stainless Steel item");
        return new HomeImprove(driver);
    }
}






