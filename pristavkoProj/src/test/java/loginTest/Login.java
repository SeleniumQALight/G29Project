package loginTest;

/**
 * Test Case 1
 */

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import parentTest.ParentTest;

public class Login extends ParentTest {

    @Test
    public void vallidLogin() {
        loginPage.loginUser(loginPage.getLogin(), loginPage.getPassword());

/*      Упрощение теста, используя метод loginUser из loginPage. Если без него, то код следующий:

        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin(loginPage.getLogin());
        loginPage.enterTextIntoInputPassword(loginPage.getPassword());
        loginPage.clickOnSubmitButton();*/

/*      Оптимизация, с использованием  loginPage.clickOnSubmitButton()
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();*/

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
        Assert.assertTrue("Menu is not present", mainPage.isMenuPresent());
    }

}