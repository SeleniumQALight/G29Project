package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {


    @Test //этот тест может быть запущен отдельно, с него можно начать метод
    public void validLogin() {

        //webDriver.get("http://v3.test.itpmgroup.com");
        loginPage.openLoginPage();

        loginPage.enterTextInputLogin("Student");
        loginPage.enterTextInputPassword("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue(
                "Avatar is not present",
                mainPage.isAvatarPresent());
    }
   @Test
   public void invalidLoginAndPass() {

       loginPage.loginUser("notValidLogin", "notValidPass");

       Assert.assertFalse(
               "Avatar is present",
               mainPage.isAvatarPresent());
   }
}


