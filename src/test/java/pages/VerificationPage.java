package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.YahooPage;

/**
 * Created by Roman LL on 10/2/2015.
 */
public class VerificationPage extends YahooPage {
    private String baseUrl="https://edit.yahoo.com/registration";

    private static final By verificationLabel =By.xpath("//h2[contains(text(), 'Verify')]");



    public VerificationPage() {
        super();
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    protected By getUniqueElement() {
        return verificationLabel;
    }

    public void OnVerificationPage(){
        Assert.assertTrue("The Verification page is not displayed", getElement(verificationLabel).isDisplayed());
    }

}
