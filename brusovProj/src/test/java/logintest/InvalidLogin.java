package logintest;

import org.junit.Assert;
import org.junit.Test;
import parrentTest.ParrentTest;


public class InvalidLogin extends ParrentTest{


    @Test
    public void loginUser(){
        loginPage.loginUser("InvalidStudent","InvalidPass");

        Assert.assertFalse("Avatar is not present",
                mainPage.isAvatarPresent());

    }

}

