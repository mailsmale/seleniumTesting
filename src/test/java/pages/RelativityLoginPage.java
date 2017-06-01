package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.YahooPage;

/**
 * Created by CEPGIo on 3/7/2016.
 */
public class RelativityLoginPage extends YahooPage{

    private static By usernameInput = By.xpath("//input[@id=\"_email\"]");
    private static By passwordInput = By.xpath("//input[@id=\"_password__password_TextBox\"]");
    private static By continueButton = By.xpath("//button[@id=\"continue\"]");
    private static By loginButton = By.xpath("//button[@id=\"_login\"]");


    public void openLoginPage(){
        //navigateTo(System.getProperty(""));
        navigateTo("https://ml20.testing.corp/Relativity");
    }

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }

    public void inputMail(String email){

        getElement(usernameInput).sendKeys(email);
    }

    public void inputPassword(String password){
        getElement(passwordInput).sendKeys(password);
    }

    public void clickOnContinueButton(){
        getElement(continueButton).click();
    }

    public void clickOnLoginButton(){
        getElement(loginButton).click();
    }

    public void performLoggining(String mail, String pass) throws InterruptedException {
        inputMail(mail);
        clickOnContinueButton();
        inputPassword(pass);
        clickOnLoginButton();
    }
}
