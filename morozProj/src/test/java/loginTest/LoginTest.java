package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin(){
        loginPage.loginUser("Student", "909090");
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent() );
    }

    @Test
    public void unValidLogin(){
        loginPage.loginUser("Student","906090");
        Assert.assertTrue("Login Input does not dispalay", loginPage.isLoginInputDisplay());

    }

}
