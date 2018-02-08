package loginTest;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LoginTestDB extends ParentTest {
    UtilsForDB utilsForDB = new UtilsForDB();

    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLoginDB() throws SQLException, IOException, ClassNotFoundException {

        loginPage.loginUser("Student",utilsForDB.getPassForLogin("Student"));

//        mainPage.clickOnMenuinstallation();
//        mainPage.clickOnInstallationFirstElementItem();
//        mainPage.clickOnInstallationAddAdd();
//        mainPage.clickOnInstallationSpares();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());


    }

    @Test
    public void nonValidLogin(){
        loginPage.loginUser("notValidLogin","notValidPass");

        Assert.assertTrue("Login field is not present", loginPage.isLoginPresent());
    }

}