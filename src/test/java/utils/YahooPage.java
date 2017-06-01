package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public abstract class YahooPage {


    protected static WebDriver driver = rWebDriver.getInstance().getWebDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,30);
    Properties props = new Properties();


    public YahooPage()  {
        try {
            props.load(new FileInputStream(new File("example.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String getBaseUrl();
    protected abstract By getUniqueElement();



    public void switchToWindowUsingHandle(String handle){
        driver.switchTo().window(handle);
    }


    public void selectFrame(String frame){
        driver.switchTo().frame(frame);
    }

    public void selectDefaultFrame(){
        driver.switchTo().defaultContent();
    }

    protected void isLoaded() throws Error {
        List<WebElement> uniqueElement = driver.findElements(getUniqueElement());

        Assert.assertTrue("Unique Element \'" + getUniqueElement().toString()
                + "\' not found for " + this.getClass().getSimpleName(), (uniqueElement.size() > 0));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void waitForPageLoaded()
    {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver driver)
                    {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new WebDriverWait(driver,30);
        try {
            wait.until(expectation);
        } catch (TimeoutException e){
            System.out.print("Page has not been loaded within 30 seconds");
        }
    }

    /*
    * public void waitForPageLoaded()
    {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver driver)
                    {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new WebDriverWait(driver,30);
        try {
            wait.until(expectation);
        } catch (TimeoutException e){
            System.out.print("Page has not been loaded within 30 seconds");
        }
    }
    *
    *
    * */


    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected WebElement getElement(By by) {
        List<WebElement> elements = getElements(by);
        for (WebElement e : elements) {
            if (e.isDisplayed() && e.isEnabled()) {
                return e;
            }
        }
        return null;
    }

    protected List<WebElement> getElements(By by) {
        return driver.findElements(by);
    }

    public WebElement getElementByValue(String value, By by) {

        for (WebElement element : getElements(by)) {

            if (element.getText().equals(value)) {
                return element;
            }
        }
        return null;
    }

    protected void selectVisibleTextBy(By by, String text) {
        WebElement selector = getElement(by);
        new Select(selector).selectByVisibleText(text);
    }
    protected void clickByJavaScript(By by){
        WebElement element = getElement(by);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", element);
        } catch (Exception e) {}
        click(element);
    }
    protected boolean elementExist(By by) {
        try {
            WebElement element = getElement(by);
            return elementVisible(element);
        } catch (Exception e) {
            return false;
        }
    }

    protected void specialClick(By by){
        WebElement element = getElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        action.click().perform();
    }

    protected void click(By by) {
        click(getElement(by));
    }

    protected void click(WebElement element) {
            element.click();
            closeAlert();
    }

    protected void closeAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Sytem shows the following message on the alert:\n" + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException ex) {
        }
    }

    protected WebElement getParent(By by) {
        return getElement(by).findElement(By.xpath(".."));
    }

    protected boolean elementVisible(WebElement element) {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    protected void inputText(By by, String text) {
        inputText(getElement(by), text);
    }

    protected void inputText(WebElement element, String text) {
        try {
            Assert.assertTrue("Cannot type text since element is not enabled", element.isEnabled());
            element.sendKeys(text);
            Assert.assertTrue("The element: " + element.toString() + " contains value: " + element.getAttribute("value").toString() + " != " + text, element.getAttribute("value").contains(text));
        }catch (NullPointerException e){
            Assert.assertTrue("The element "+element.toString()+ " was not found", false);
        }
    }

    protected void inputTextWithSpecialAssertion (By by, String text, String expectedValueAfterInput){
        inputTextWithSpecialAssertion(getElement(by), text, expectedValueAfterInput);
    }

    protected void inputTextWithSpecialAssertion (WebElement element, String text, String expectedValueAfterInput) {
        try {
            Assert.assertTrue("Cannot type text since element is not enabled", element.isEnabled());
            element.sendKeys(text);
            Assert.assertTrue("The element: " + element.toString() + " contains value: " + element.getAttribute("value").toString() + " != " +
                    expectedValueAfterInput, element.getAttribute("value").contains(expectedValueAfterInput));
        }catch (NullPointerException e){
            Assert.assertTrue("The element "+element.toString()+ " was not found", false);
        }
    }

    protected void selectRadioButton(By by) {
        selectRadioButton(getElement(by));
    }

    protected void selectRadioButton(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void selectCheckBox(By by) {
        selectCheckBox(getElement(by));
    }

    protected void selectCheckBox(WebElement element) {
        while (!element.isSelected()) {
            element.click();
        }
    }

    protected WebElement findElementByAttributeValue(By by, String attribute, String value) {
        for (WebElement element : getElements(by)) {
            if (element.getAttribute(attribute).contains(value)) {
                return element;
            }
        }
        return null;
    }
    protected void selectFromDropDown(By by, String visibleText){
        WebElement dropDown=driver.findElement(by);
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(visibleText);
        }catch (Exception e){
            Assert.assertTrue("Could not select the option with the following visible text: "+visibleText, false);
        }
    }

    protected String getVisibleText(By by){
        return  getVisibleText(getElement(by));
    }

    protected String getVisibleText(WebElement element){
        return element.getText();
    }

    public void sleepFor(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
        }
    }





}