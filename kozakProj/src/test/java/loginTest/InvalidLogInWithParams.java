package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)                //вказуємо, що цей потрібно буде запустити з декількома параметрами

public class InvalidLogInWithParams extends ParentTest {
    String login,password;

    public InvalidLogInWithParams(String login, String password) {                    //конструктор закидує дані
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters ( name = "login ={0} pass = {1}")                    //блок, що дає нам параметри
    public static Collection testData(){
    return Arrays.asList(new Object[][]{
            {"Student","111111"},
            {"qqqqgfq","909090"},
            {"",""}
    });
    }

    @Test
    public void invalidLogInWithParams() {
        loginPage.loginUser(login,password);
        Assert.assertTrue("User should not be logged ",loginPage.authorizationFormIsPresent());
    }
}
