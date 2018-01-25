package logintest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;


public class InvalidLogin extends ParentTest {


    @Test
    public void loginUser(){
        loginPage.loginUser("InvalidStudent","InvalidPass");

        Assert.assertFalse("Avatar is present",
                mainPage.isAvatarPresent());

    }

}

