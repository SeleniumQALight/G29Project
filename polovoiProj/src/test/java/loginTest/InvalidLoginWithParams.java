package loginTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class InvalidLoginWithParams extends ParentTest {
    String login, pass;

    public InvalidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{{"Student", "121"}, {"121", "909090"}});
    }


        @Test
        public void invalidLoginWithParams () {
            loginPage.loginUser("Student", "909090");
            Assert.assertTrue("", loginPage.isLoginInputDisplay());
        }

    }




