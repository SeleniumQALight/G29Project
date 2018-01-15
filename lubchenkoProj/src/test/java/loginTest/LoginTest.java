package loginTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest{

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.loginUser("Student","909090");
       /* loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();*/

        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent() );

    }

}


