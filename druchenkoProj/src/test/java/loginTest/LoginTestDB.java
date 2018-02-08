package loginTest;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LoginTestDB extends ParentTest{

    UtilsForDB utilsForDB = new UtilsForDB();


    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        loginPage.loginUser("Student", utilsForDB.getPassForLogin("Student"));
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());

    }

    @Test
    public void inValidLogin(){
        loginPage.loginUser("Student", "404040");
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());

    }



}