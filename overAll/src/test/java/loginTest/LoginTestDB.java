package loginTest;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LoginTestDB extends ParentTest {
    UtilsForDB utilsForDB =
            new UtilsForDB();
        @Test
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        loginPage.loginUser("Student",
     utilsForDB.getPassForLogin("Student"));
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent() );
    }

    @Test
    public void unValidLogin(){
        loginPage.loginUser("Student","906090");
        Assert.assertTrue("Login Input does not dispalay", loginPage.isLoginInputDisplay());
    }

}
