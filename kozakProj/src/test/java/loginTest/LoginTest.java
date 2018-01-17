package loginTest;


import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;


public class LoginTest extends ParentTest {


    @Test
    /**
     * / test to verify the login functionality with valid credentials
     */
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue("Avatar is not present",                              //Асерт - частина Junit, використовується для провірки.
                mainPage.isAvatarPresent());
    }

    @Test
    /**
     * / test to verify the login functionality with invalid login
     */
    public void notValidLogin() {
        loginPage.loginUser("invalidLogin", "909090");
        Assert.assertTrue("Login form is present, user was not login",
                loginPage.authorizationFormIsPresent());
    }

    @Test
    /**
     * / test to verify the login functionality with invalid password
     */
    public void notValidPassword() {
        loginPage.loginUser("Student", "909www090");
        Assert.assertTrue("Login form is present, user was not login",
                loginPage.authorizationFormIsPresent());
    }


}
