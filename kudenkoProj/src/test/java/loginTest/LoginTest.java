package loginTest;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;


public class LoginTest extends ParentTest{



    @Test
    public void validLogin(){

        webDriver.get("http://v3.test.itpmgroup.com");
        mainPage.enterName("student");
        mainPage.enterPass("909090");
        mainPage.cliclElement();
        mainPage.isAvatarPresent();

    }


}
