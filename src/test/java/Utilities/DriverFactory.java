package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    // it will not allow to create an object Outside from this class
    private  DriverFactory() {
        // Empty constructor
    }
    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    private static final DriverFactory instance = new DriverFactory();


    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        String environment = System.getProperty("environment") == null ? "local" : System.getProperty("environment");
        String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        URL gridUrl = null;
        try {
            gridUrl= new URL(ReadConfigFiles.getPropertyValues("gridUrl"));
            LOGGER.info("Selenium Grid URL:" + gridUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (environment.equals("remote") && browser.equals("chrome")) {
            LOGGER.info("executing the automation scripts in selenium grid using Chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            return new RemoteWebDriver(gridUrl,chromeOptions);
        } else if (environment.equals("remote") && browser.equals("firefox")) {
            LOGGER.info("executing the automation scripts in selenium grid using firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            return new RemoteWebDriver(gridUrl, firefoxOptions);
        } else if (environment.equals("remote") && browser.equals("edge")) {
            LOGGER.info("executing the automation scripts in selenium grid using edge");
            EdgeOptions edgeOptions = new EdgeOptions();
            return new RemoteWebDriver(gridUrl, edgeOptions);
        } else {
            LOGGER.info("executing the automation scripts in local using chrome");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    });

   public WebDriver getDriver() {
        return driver.get();
    }
    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
