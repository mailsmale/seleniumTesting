package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.YahooPage;

/**
 * Created by Roman Lapii on 9/29/2015.
 */
public class SignUpPage extends YahooPage {

    private static final String baseUrl = "https://edit.yahoo.com/registration?.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com&.src=ym&fsredirect=1&fs=IF2HOyWHafAc9gAMyUugcWNjRVnf7HLFdv8gr.I6nPwPZ1D2Gvmjjrl0YtEk8JGx3IPIEBIQ";

    //Locators
    private static final By createBtn = By.cssSelector("button#reg-submit-button");
    private static final By fNameFld = By.cssSelector("#usernamereg-firstName");
    private static final By lNameFld = By.cssSelector("#usernamereg-lastName");
    private static final By usernameFld = By.cssSelector("#usernamereg-yid");
    private static final By passwordFld = By.cssSelector("#usernamereg-password");
    private static final By mobileFldCountry = By.cssSelector("[name='shortCountryCode']");
    private static final By mobileFld = By.cssSelector("#usernamereg-phone");
    private static final By recoveryNumFld = By.cssSelector("#mobile-rec");
    private static final By relationshipFld = By.cssSelector("#relationship");
    private static final By monthDropDown = By.cssSelector("#usernamereg-month");
    private static final By dayDropDown = By.cssSelector("#usernamereg-day");
    private static final By yearDropDown = By.cssSelector("#usernamereg-year");
    private static final By birthDiv = By.xpath("//div[@name='birthDate']");

    //Validation Messages
    private static final String validationMessage = "This is required.";


    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    protected By getUniqueElement() {
        return createBtn;
    }


    //Accepts only female or male as the argument
    public void selectGender(String gender) {
        if (gender == "female" || gender == "male") {
            click(By.xpath("//li[text()=" + gender + "]"));
            Assert.assertTrue("Gender should be either male or female", false);
        }
    }

    public void enterFName(String fName) {
        inputText(fNameFld, fName);
    }

    public void enterLName(String lName) {
        inputText(lNameFld, lName);
    }

    public void enterUsername(String userName) {
        inputText(usernameFld, userName);
    }

    public void enterPassword(String password) {
        inputText(passwordFld, password);
    }

    public void enterPhone(String phone) {

        //String convertedPhone = convertPhone(phone);
        //inputTextWithSpecialAssertion(mobileFld, phone, convertedPhone);
        selectFromDropDown(mobileFldCountry, "Ukraine \u202A(+380)\u202C");
        inputText(mobileFld, phone);
    }

    private String convertPhone(String phone) {
        StringBuilder sb = new StringBuilder(15);
        StringBuilder temp = new StringBuilder(phone);

        while (temp.length() < 10)
            temp.insert(0, "0");

        char[] chars = temp.toString().toCharArray();

        sb.append("(");
        for (int i = 0; i < chars.length; i++) {
            if (i == 3)
                sb.append(") ");
            else if (i == 6)
                sb.append("-");
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public void enterRecoverPhone(String recoverPhone) {
        String convertedPhone = convertPhone(recoverPhone);
        inputTextWithSpecialAssertion(recoveryNumFld, recoverPhone, convertedPhone);
    }

    public void enterRelationship(String relationship) {
        inputText(relationshipFld, relationship);
    }

    public void selectBirthday(String month, String day, String year) {
        selectFromDropDown(monthDropDown, month);
        inputText(dayDropDown, day);
        inputText(yearDropDown, year);
    }

    public VerificationPage clickCreateAccount() {
        click(createBtn);
        return new VerificationPage();
    }

    public enum ValidationField {
        FIRST_NAME("firstName", "First Name"),
        LAST_NAME("lastName", "Last Name"),
        EMAIL("yid", "Email address"),
        PASSWORD("password", "Password"),
        MOBILE_PHONE("phone", "Mobile Phone"),
        BIRTH("birthDate", "Birth");
        public String getErrorBoxID(){
            return this.errorBoxId;
        }
        public String toString(){
            return this.stringRepresentation;
        }
        ValidationField(String errorBoxIDPart, String stringRepresentation){
            this.errorBoxId = "#reg-error-" + errorBoxIDPart;
            this.stringRepresentation = stringRepresentation;
        }
        private String stringRepresentation;
        private String errorBoxId;
    }

    public SignUpPage verifyThatValidationErrorIsDisplayed(ValidationField validationField) {
        Assert.assertTrue("The actual validation message under the " +
                        validationField.toString() + " field does not match with expected.",
                getElement(By.cssSelector(validationField.getErrorBoxID())).
                        getText().equals(validationMessage));
        return this;
    }

    //Verify that given filed is in error state
    public Verify verifyTheFollowing() {
        return new Verify();
    }

    public class Verify {
        private Verify() {
        }

        //Verify that given filed is in error stat
        public Verify whetherFirstNameInErrorState() {
            SignUpPage.this.isFieldInErrorState(fNameFld);
            return this;
        }

        public Verify whetherLastNameInErrorState() {
            SignUpPage.this.isFieldInErrorState(lNameFld);
            return this;
        }

        public Verify whetherUserNameInErrorState() {
            SignUpPage.this.isFieldInErrorState(usernameFld);
            return this;
        }

        public Verify whetherPasswordInErrorState() {
            SignUpPage.this.isFieldInErrorState(passwordFld);
            return this;
        }

        public Verify whetherPhoneInErrorState() {
            SignUpPage.this.isFieldInErrorState(mobileFld);
            return this;
        }

        public Verify whetherBirthdayInErrorState() {
            SignUpPage.this.isFieldInErrorState(birthDiv);
            return this;
        }

        //Verify that appropriate validation message appears under the given field
        public Verify whetherValidationMessageOfTheFirstNameFieldIsDisplayed() {
            verifyThatValidationErrorIsDisplayed(ValidationField.FIRST_NAME);
            return this;
        }
        public Verify whetherValidationMessageOfTheLastNameFieldIsDisplayed() {
            verifyThatValidationErrorIsDisplayed(ValidationField.LAST_NAME);
            return this;
        }

        public Verify whetherValidationMessageOfThePasswordFieldIsDisplayed() {
            verifyThatValidationErrorIsDisplayed(ValidationField.PASSWORD);
            return this;
        }

        public Verify whetherValidationMessageOfTheMobileFieldIsDisplayed() {
            verifyThatValidationErrorIsDisplayed(ValidationField.MOBILE_PHONE);
            return this;
        }

        public Verify whetherValidationMessageOfTheBirthdayDropDownsIsDisplayed() {
            verifyThatValidationErrorIsDisplayed(ValidationField.BIRTH);
            return this;
        }

        public Verify whetherValidationMessageOfTheGenderRadioButtonsIsDisplayed() {
            verifyThatValidationErrorIsDisplayed(ValidationField.EMAIL);
            return this;
        }

    }

    public void isFieldInErrorState(By by) {
        Assert.assertTrue("The element: " + by.toString() +
                " is not in the error state",
                getElement(by).getAttribute("class").toString().contains("error"));
    }

    private void verifyPredifinedValue(By by, String expectedValue) {
        Assert.assertTrue("PredifinedValue does not match with expected for element: " + by.toString(), getElement(by).findElement(By.xpath("//preceding-sibling::label")).getText().equals(expectedValue));
    }

    public SignUpPage verifyPredifinedValueForFirstName() {
        verifyPredifinedValue(fNameFld, "First name");
        return this;
    }

    public SignUpPage verifyPredifinedValueForLastName() {
        verifyPredifinedValue(lNameFld, "Last name");
        return this;
    }

    public SignUpPage verifyPredifinedValueForUserName() {
        verifyPredifinedValue(usernameFld, "Yahoo username");
        return this;
    }

    public SignUpPage verifyPredifinedValueForPassword() {
        verifyPredifinedValue(passwordFld, "Password");
        return this;
    }

    private void verifyPredifinedValueParent(By by, String forField, String expectedValue) {
        Assert.assertTrue("PredifinedValue does not match with expected for element: " + by.toString(), getElement(by).findElement(By.xpath("//preceding-sibling::label")).findElement(By.xpath("//*[@for=\'" + forField + "\']")).getText().equals(expectedValue));
    }

    public SignUpPage verifyPredifinedValueForMobile() {
        verifyPredifinedValueParent(mobileFld, "mobile", "Mobile number");
        return this;
    }

    public enum Gender {
        MALE("Male"){

        },
        FEMALE("Female"){

        };
        private Gender(String stringForID) {
            this.stringForId = stringForID;
        }
        private String stringForId;
        @Override
        public String toString(){
            return this.stringForId;
        }
    }
}
