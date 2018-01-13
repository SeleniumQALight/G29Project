package loginTest;

import org.junit.Test;
import pages.LoginPage;
import parentTest.ParentTest;


public class LoginTest extends ParentTest{



    @Test
    public void validLogin(){

        loginPage.openLoginPage();
        //webDriver.get("http://v3.test.itpmgroup.com");
        loginPage.enterName("student");
        loginPage.enterPass("909090");
        loginPage.clickElement();
        mainPage.isAvatarPresent();
    }
}
