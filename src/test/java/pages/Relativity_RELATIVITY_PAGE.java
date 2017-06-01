package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.YahooPage;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by CEPGIo on 3/7/2016.
 */
public class Relativity_RELATIVITY_PAGE extends YahooPage {

    private static By showHideFiltersLink = By.xpath(".//a[contains(@id, \"List_FilterSwitch\")]");

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }

    protected void performTheNextFilteringOnThePage(String name, String value){
        WebElement filterLink = getElement(showHideFiltersLink);
        if(filterLink.getAttribute("Title").contains("Show Filters") ){
            filterLink.click();
        }
        WebElement filterInput = getElement(By.xpath("//input[contains(@name, \"itemList_\") and contains(@name, \"[" + name + "]\")]"));

        //try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
        //WebElement filterInput = driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_itemList_FILTER-BOOLEANSEARCH[Name]-T\"]"));
        //WebElement filterInput = getElement(By.xpath("//*[@id=\"ctl00_ctl00_itemList_FILTER-BOOLEANSEARCH[Name]-T\"]"));
        filterInput.clear();
        filterInput.sendKeys(value);
        filterInput.sendKeys(Keys.ENTER);
        waitForPageLoaded();


    }
}
