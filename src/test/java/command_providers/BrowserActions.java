package command_providers;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions openBrowser(String url) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();;
        return this;
    }
    public WebDriver getDriver() {
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String handle : handles) {

            if (!handle .equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

        driver.switchTo().window(currentHandle);
        return driver;
    }

    public void close() {
        driver.quit();
    }

    public String captureTitles() {
        return driver.getTitle();

    }
}
