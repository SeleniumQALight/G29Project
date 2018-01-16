package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest{

    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin(){


        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());

    }

//    @Test
//    public void inValidLogin(){
//        loginPage.openLoginPage();
//        loginPage.enterTextIntoInputLogin("Student1");
//        loginPage.enterPassIntoInputPassword("9090");
//        loginPage.clickOnSubmitButton();
//
//        Assert.assertFalse(" ", mainPage.isAvatarPresent());
//
//    }



}