package loginTest;

import Libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LoginTestDB extends ParentTest{
    UtilsForDB utilsForDB = new UtilsForDB();

    // можно запустить без мейн метода (заимпортить junit)
    @Test
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        loginPage.openLoginPage();
        loginPage.enterTextIntoImputLogin("Student");
        loginPage.enterTextIntoInputPass(utilsForDB.getPassForLogin("Student"));
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());  //proverka - esli da - to ni4ego ne budet- esli net to vuvedet soobwenie

    }


}
