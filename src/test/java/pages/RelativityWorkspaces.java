package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.YahooPage;

/**
 * Created by CEPGIo on 3/7/2016.
 */
public class RelativityWorkspaces extends Relativity_RELATIVITY_PAGE {



    public String getBaseUrl() {
        return null;
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }

    public void goToTheFirstWorkspaceContainsTheNexText(String workspaceName){
        driver.switchTo().frame("ListTemplateFrame");
        performTheNextFilteringOnThePage("Name", "Office 2013");
        getElement(By.xpath(".//tr[1]//a[@class=\"itemListPrimaryLink\"][1]")).click();
    }


}
