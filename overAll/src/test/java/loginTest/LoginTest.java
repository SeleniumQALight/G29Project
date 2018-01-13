package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParenTest;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParenTest{

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent() );

    }

}
