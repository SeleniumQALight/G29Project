package loginTest;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import pages.ParentPage;
import parentTest.ParentTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class InvalidLoginWithParams extends ParentTest{
    String login,pass;

    public InvalidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    @Parameterized.Parameters(name="login={0} pass={1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student","11111"},
                {"11111","909090"}
        });
    }


    @Test
    public void invalidLogInWithParams(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");

        Assert.assertTrue("",loginPage.isLoginInputDisplay());
    }
}
