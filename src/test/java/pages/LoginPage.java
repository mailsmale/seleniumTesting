package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.YahooPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman Lapii on 9/29/2015.
 */
public class LoginPage extends YahooPage {
    private String baseUrl="https://login.yahoo.com/config/login?.intl=en&.src=ym";

    private static final By signInBtn=By.cssSelector("button#login-signin");
    private static final By signUpLink=By.cssSelector("a#login-signup");

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    protected By getUniqueElement() {
        return signInBtn;
    }

    public void onLoginPage() {
        isLoaded();
    }

    public SignUpPage clickSignUp(){
        clickByJavaScript(signUpLink);
        return new SignUpPage();
    }

    public void OpenLoginPage(){
        navigateTo(getBaseUrl());
    }
}
