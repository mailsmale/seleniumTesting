package Tests;

import builders.SignUpPageBuilder;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.SignUpPage;
import pages.VerificationPage;
import utils.rWebDriver;


public class TestSuite1 {
    static SignUpPage signUpPage = new SignUpPage();
    static LoginPage loginPage = new LoginPage();

    @Before
    public void TestSetup(){
         loginPage.OpenLoginPage();
    }

    @AfterClass
    public static void SuiteTardown(){
        rWebDriver.closeWebDriver();
    }

    @Test
    public void TestCase1() {
        loginPage.clickSignUp();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.clickCreateAccount();
        signUpPage.verifyTheFollowing()
                .whetherFirstNameInErrorState()
                .whetherLastNameInErrorState()
                .whetherPasswordInErrorState()
                .whetherUserNameInErrorState()
                .whetherPhoneInErrorState()
                .whetherBirthdayInErrorState();
        signUpPage.verifyTheFollowing()
                .whetherValidationMessageOfTheFirstNameFieldIsDisplayed()
                .whetherValidationMessageOfTheLastNameFieldIsDisplayed()
                .whetherValidationMessageOfThePasswordFieldIsDisplayed()
                .whetherValidationMessageOfTheMobileFieldIsDisplayed()
                .whetherValidationMessageOfTheBirthdayDropDownsIsDisplayed()
                .whetherValidationMessageOfTheGenderRadioButtonsIsDisplayed();
    }

    @Test
    public void TestCase2() {
        loginPage.clickSignUp();
        SignUpPageBuilder.setValuesInTheFollowingFields()
                .setFirstName("Roman")
                .setLastName("Iipal")
                .setBirthDate("January", "26", "1992")
                .setPassword("rQadasd556987")
                .setUserName("conectic363738")
                .setPhone("936854466")
                .setGender(SignUpPage.Gender.MALE)
                .built();
        signUpPage.clickCreateAccount();
        VerificationPage verificationPage = new VerificationPage();
        verificationPage.OnVerificationPage();
    }
}
