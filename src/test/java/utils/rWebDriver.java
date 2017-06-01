package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class rWebDriver {
    private static rWebDriver instance;
    public String browser="chrome";
    private WebDriver driver;

    private rWebDriver() {
        String driverPath = "";
        if (browser.equals("chrome")) {
            driverPath = System.getProperty("user.dir") + "/src/drivers/";
            String os = getOperatingSystemType().toString();
            if (getOperatingSystemType().toString() == "Windows") {
                driverPath = driverPath + "chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath );
            } else  {
                driverPath = driverPath + "chromedriver";
                System.setProperty("webdriver.chrome.driver", driverPath);
            }
            System.out.println("Trying to start chrome driver from: " + driverPath);
            driver = new ChromeDriver(getCapabilityForHandlingCertificationError());
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.switchTo().window(driver.getWindowHandle());

        } else if (browser.equals("ie")) {
            String iePath = "C:/WebDrivers/IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", iePath);
            driver = new InternetExplorerDriver();

        } else {
            driver = new FirefoxDriver();

        }


    }

    protected DesiredCapabilities getCapabilityForHandlingCertificationError(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        return capability;
    }

    public static synchronized rWebDriver getInstance() {
        if (instance == null) {
            instance = new rWebDriver();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public static void closeWebDriver() {
        rWebDriver.getInstance().getWebDriver().close();
    }

    public enum OSType {
        Windows, MacOS, Linux, Other
    }

    protected static OSType detectedOS;

    public static OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                detectedOS = OSType.MacOS;
            } else if (OS.indexOf("win") >= 0) {
                detectedOS = OSType.Windows;
            } else if (OS.indexOf("nux") >= 0) {
                detectedOS = OSType.Linux;
            } else {
                detectedOS = OSType.Other;
            }
        }
        return detectedOS;
    }
}
