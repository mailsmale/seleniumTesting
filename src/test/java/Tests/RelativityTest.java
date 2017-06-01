package Tests;

import lists.DocumentList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.RelativityAdminLevelPage;
import pages.RelativityLoginPage;
import pages.RelativityWorkspaces;
import pages.SignUpPage;
import panels.DocumentLayoutPanel;
import utils.rWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by CEPGIo on 3/7/2016.
 */
public class RelativityTest {



    WebDriver driver = rWebDriver.getInstance().getWebDriver();
    RelativityLoginPage loginPage = new RelativityLoginPage();
    RelativityAdminLevelPage ralp = new RelativityAdminLevelPage();
    RelativityWorkspaces rwp = new RelativityWorkspaces();
    DocumentList dl = new DocumentList();
    DocumentLayoutPanel dlp = new DocumentLayoutPanel();





    @Before
    public void TestSetup() throws Exception {
        loginPage.openLoginPage();
        loginPage.performLoggining("sbilorys@kcura.com", "Test1234!");
        ralp.goToTheWorkspacesTab();
        rwp.goToTheFirstWorkspaceContainsTheNexText("cepgio");
        dl.goToTheFirstDocumentViewPage();
        dlp.getRelativityDocumentLayoutValues();
    }

    @AfterClass
    public static void SuiteTardown()  {
        //rWebDriver.closeWebDriver();
    }

    @Test
    public void TestCase1() {
        System.out.println("hello, im serhii");
    }


}
