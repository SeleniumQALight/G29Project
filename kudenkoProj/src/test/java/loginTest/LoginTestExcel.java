package loginTest;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;


public class LoginTestExcel extends ParentTest{

    private ExcelDriver excelDriver;

    @Test
    public void validLogin() throws IOException {

        Map data = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");


        //loginPage.openLoginPage();
        loginPage.loginUser(data.get("login").toString(), data.get("pass").toString());
        //webDriver.get("http://v3.test.itpmgroup.com");
//        loginPage.enterName("student");
//        loginPage.enterPass("909090");
//        loginPage.clickElement();
        mainPage.isAvatarPresent();
    }
}
