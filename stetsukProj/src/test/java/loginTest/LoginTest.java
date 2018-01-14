package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {


    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() {
/*
        loginPage.openLoginPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnSubmitElement();
*/
        loginPage.loginUser("Student","909090");

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
    }

    @Test
    public void nonValidLogin(){
        loginPage.loginUser("notValidLogin","notValidPass");

        Assert.assertTrue("Login field is not present", loginPage.isLoginPresent());
    }

}