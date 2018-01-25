package loginTest;

import org.junit.Assert;
import org.junit.Test;

import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent() );
    }

    @Test
    public void unValidLogin(){
        loginPage.loginUser("Student","906090");
        Assert.assertTrue("Login Input does not dispalay"
                , loginPage.isLoginInputDisplay());
    }

}
