package loginTest;

import org.junit.Assert;
import org.junit.Test;

import parentTest.ParenTest;

public class LoginTest extends ParenTest{

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
        loginPage.liginUser("Student","906090");
        Assert.assertTrue("Login Input does not dispalay", loginPage.isLoginInputDisplay());
    }

}
