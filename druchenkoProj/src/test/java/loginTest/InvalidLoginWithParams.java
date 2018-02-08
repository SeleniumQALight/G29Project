package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)

public class InvalidLoginWithParams extends ParentTest{
    String login, pass;

    public InvalidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "login = {0}   pass = {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "111111"},
                {"Scudent", "909090"},
        });
    }

    @Test
    public void invalidLoginWithParams(){
        loginPage.loginUser(login, pass);
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());
    }
}
