package loginTest;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;


public class LoginTestDB extends ParentTest{



    @Test
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {

        UtilsForDB utilsForDB = new UtilsForDB();

        loginPage.loginUser("Student", utilsForDB.getPassForLogin("Student"));
        //Assert.assertTrue(mainPage.isAvatarPresent());
        checkAC("Avatar is not present", mainPage.isAvatarPresent(), true);

        isTestSuccess = true;
    }
}
