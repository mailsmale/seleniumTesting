package SwitchDriverTemplate;

import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class SwitchDriver {
    WebDriver driver;
    WebDriver driverSwitch = null;
    Generic obj;
    public static String URL1 = "https://google.com";
    public static String URL2 = "https://gmail.com";

    /**
     * Set up browser settings
     */
    @Before
    public void setUp() {
        // Create Objects
        obj = new Generic();
        // Go to google.com
        if (URL1 != null)
            driver = obj.getDriver(URL1, "chrome");

        // Go to gmail.com
        if (URL2 != null) {
            driverSwitch = obj.getDriver(URL2, "chrome");
            if (driver == null) {// If only gmail.com
                driver = driverSwitch;
                driverSwitch = null;
            }
        }
    }

    /**
     * Test
     */
    @Test
    public void testSwitchingDriver() {
        // Entering text in the first driver instance
        driver.navigate().to("http://www.protechskills.com/testing/automation-testing/selenium/switching-multiple-webdriver-instances");
        driverSwitch.navigate().to("http://www.protechskills.com/testing/automation-testing/selenium/switching-multiple-webdriver-instances");
        driver.navigate().to("http://www.protechskills.com/testing/automation-testing/selenium/switching-multiple-webdriver-instances");
        driverSwitch.navigate().to("http://www.protechskills.com/testing/automation-testing/selenium/switching-multiple-webdriver-instances");

    }

    /**
     * Tear down the setup after test completes
     */
    @After
    public void tearDown() {
        // Closing both the browser windows
        // Accessing the generic method by passing the driver instance with
        // which the suer wants to communicate
        if (driver != null) {
            obj.quitDriver(driver);
        }
        if (driverSwitch != null) {
            obj.quitDriver(driverSwitch);
        }
    }
}