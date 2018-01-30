package loginTest;


import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;


public class LoginTestFromExcel extends ParentTest {
private ExcelDriver escelDriver;


@Test
    public void validLogin() throws IOException {
    Map data = escelDriver.getData(configProperties.DATA_FILE(), "validLogOn");   // обявили змінну у яку будемо передавати дані, потім ми дали шлях до файла, потім дали шлях до листа файла
    loginPage.loginUser(data.get("login").toString(), data.get("pass").toString());
    Assert.assertTrue("Login form is present, user was not login",
            loginPage.authorizationFormIsPresent());
}


//    @Test
//    /**
//     * / test to verify the login functionality with valid credentials
//     */
//    public void validLogin() {
//        loginPage.openLoginPage();
//        loginPage.enterTextIntoInputLogin("Student");
//        loginPage.enterTextIntoInputPass("909090");
//        loginPage.clickOnSubmitButton();
//        Assert.assertTrue("Avatar is not present",                              //Асерт - частина Junit, використовується для провірки.
//                mainPage.isAvatarPresent());
//    }
//
//    @Test
//    /**
//     * / test to verify the login functionality with invalid login
//     */
//    public void notValidLogin() {
//        loginPage.loginUser("invalidLogin", "909090");
//        Assert.assertTrue("Login form is present, user was not login",
//                loginPage.authorizationFormIsPresent());
//    }
//
//    @Test
//    /**
//     * / test to verify the login functionality with invalid password
//     */
//    public void notValidPassword() {
//        loginPage.loginUser("Student", "909www090");
//        Assert.assertTrue("Login form is present, user was not login",
//                loginPage.authorizationFormIsPresent());
//    }


}
