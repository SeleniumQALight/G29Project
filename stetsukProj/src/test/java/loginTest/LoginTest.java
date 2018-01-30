package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {


    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() {

        loginPage.loginUser("Student","909090");

//        mainPage.clickOnMenuinstallation();
//        mainPage.clickOnInstallationFirstElementItem();
//        mainPage.clickOnInstallationAddAdd();
//        mainPage.clickOnInstallationSpares();

//        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
        checkAC("Avatar is not present", mainPage.isAvatarPresent(), true);
    }

    @Test
    public void nonValidLogin(){
        loginPage.loginUser("notValidLogin","notValidPass");

        Assert.assertTrue("Login field is not present", loginPage.isLoginPresent());
    }

}