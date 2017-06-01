package lists;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.YahooPage;

/**
 * Created by im going to use this on 3/8/2016.
 */
public class DocumentList extends YahooPage {



    private static By documentsPath = By.xpath("//*[contains(@id, itemList_ROW)]/td[6]/a");

    public void goToTheFirstDocumentViewPage(){
        waitForPageLoaded();
        goToTheDocumentListFrame();
        getElement(By.xpath("//*[contains(@id, itemList_ROW0)]/td[6]/a")).click();
        waitForPageLoaded();
    }

    private void goToTheDocumentListFrame(){
        waitForPageLoaded();
        selectDefaultFrame();
        selectFrame("ListTemplateFrame");
    }










    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }
}
