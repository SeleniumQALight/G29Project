package loginTest;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import parentTest.ParentTest;


public class LoginTest extends ParentTest{



    @Test
    public void validLogin(){

        loginPage.openLoginPage();
        loginPage.loginUser("Student", "909090");
        //Assert.assertTrue(mainPage.isAvatarPresent());
        checkAC("Avatar is not present", mainPage.isAvatarPresent(), true);
    }
}
