package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.YahooPage;

/**
 * Created by CEPGIo on 3/7/2016.
 */
public class RelativityAdminLevelPage extends YahooPage {


    private static By workspacesLink = By.xpath("//a[text()=\"Workspaces\"][1]");

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }

    public void goToTheWorkspacesTab(){
        driver.findElement(workspacesLink).click();
    }
}
