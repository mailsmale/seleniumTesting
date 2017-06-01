package SwitchDriverTemplate;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Generic {
    WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param appUrl The application url under test
     * @param browser The browser that needs to be launched
     * @return driver the current driver
     */
    public WebDriver getDriver(String appUrl, String browser) {
        getBrowser(browser);
        driver.get(appUrl);
        return driver;
    }

    /**
     * @param browser The browser that needs to be launched
     */
    private void getBrowser(String browser) {
        String chromePathWin = "C:/WebDrivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePathWin);
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(capability);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Browser cannot be launched");
        }
    }

    /**
     * @param drv The driver instance on which the action needs to be performed
     */
    public void quitDriver(WebDriver drv) {
        drv.quit();
    }
}
