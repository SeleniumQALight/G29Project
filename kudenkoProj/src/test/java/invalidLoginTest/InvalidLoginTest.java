package invalidLoginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class InvalidLoginTest extends ParentTest{
    @Test
    public void inValidLogin(){

        loginPage.loginUser("notValid", "notValid");
        mainPage.isAvatarPresent();
    }
}

