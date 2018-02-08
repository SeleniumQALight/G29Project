package loginTest;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;


public class LoginTestDB extends ParentTest {
    UtilsForDB utilsForDB = new UtilsForDB();

    @Test
    /**
     * / test to verify the login functionality with valid credentials
     */
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass(utilsForDB.getPassForLogin("Student"));
        loginPage.clickOnSubmitButton();
        Assert.assertTrue("Avatar is not present",mainPage.isAvatarPresent());     //Асерт - частина Junit, використовується для провірки.

    }

}
