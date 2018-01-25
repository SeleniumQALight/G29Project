package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest{

    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin(){
        loginPage.loginUser("Student", "909090");
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());

    }

    @Test
    public void inValidLogin(){
        loginPage.loginUser("Student", "404040");
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());

    }



}