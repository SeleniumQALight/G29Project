package loginTest;

import javafx.print.Collation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)


public class InvalidLogInWithParam extends ParentTest{
    String login,pass;

    public InvalidLogInWithParam(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    @Parameterized.Parameters (name = "login={0} pass = {1}") // это блок который будет давать нам параметры, ран нашего теста//верни нам масив данніх
     public static Collection testData (){
        return Arrays.asList(new Object[][]{
                { "Student", "11111"},{"11111","909090"}
        });

    }

    @Test
    public void invalidLogInWithParam(){
        loginPage.loginUser(login,pass);
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());
    }
}
