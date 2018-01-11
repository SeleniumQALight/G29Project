package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {


    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() {

        loginPage.openLoginPage();
        loginPage.enterTextIntuInputLogin("Student");
        loginPage.entetTextInToInputePass("909090");
        loginPage.clickOnSubmitElement();
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
    }

}