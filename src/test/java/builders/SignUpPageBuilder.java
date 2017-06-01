package builders;

import pages.SignUpPage;

public class SignUpPageBuilder extends SignUpPage {
    private static SignUpPage page = new SignUpPage();

    public static Builder setValuesInTheFollowingFields() {
        return new SignUpPageBuilder().new Builder();
    }

    public class Builder {
        private Builder() {
        }
        public Builder setFirstName(String firstName) {
            SignUpPageBuilder.this.enterFName(firstName);
            return this;
        }

        public Builder setLastName(String lastName) {
            SignUpPageBuilder.this.enterLName(lastName);
            return this;
        }

        public Builder setPassword(String password) {
            SignUpPageBuilder.this.enterPassword(password);
            return this;
        }

        public Builder setUserName(String userName) {
            SignUpPageBuilder.this.enterUsername(userName);
            return this;
        }

        public Builder setPhone(String phone) {
            SignUpPageBuilder.this.enterPhone(phone);
            return this;
        }

        public Builder setGender(Gender gender) {
            SignUpPageBuilder.this.page.selectGender(gender.toString());
            return this;
        }

        public Builder setBirthDate(String month, String day, String year) {
            SignUpPageBuilder.this.selectBirthday(month, day, year);
            return this;
        }

        public SignUpPageBuilder built() {
            return SignUpPageBuilder.this;
        }
    }
}
