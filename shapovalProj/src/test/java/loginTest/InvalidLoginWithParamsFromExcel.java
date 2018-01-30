package loginTest;

import Libs.SpreadsheetData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static pages.ParentPage.configProperties;

@RunWith(value = Parameterized.class) // govorim junit 4to etot klass nygno zapystit' s parametrami
public class InvalidLoginWithParamsFromExcel extends ParentTest {
    String login,pass;

    public InvalidLoginWithParamsFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "login = {0} pass = {1}")
    public static Collection testData() throws IOException {
//        return Arrays.asList(new Object[][]{
//            {"Student","11111"},
//            {"","11111"},
//            {"11111","909090"}
//        });
        InputStream spreadsheet = new FileInputStream(
                configProperties.DATA_FILE_SUITE() + "testDataSuit.xls"
        );
        return new SpreadsheetData(spreadsheet,"InvalidLogOn").getData();
    }

    @Test
    public void invalidLoginWithParams (){
        loginPage.openLoginPage();
        loginPage.enterTextIntoImputLogin(login);
        loginPage.enterTextIntoInputPass(pass);
        loginPage.clickOnSubmitButton();
        Assert.assertFalse("User should not be loged", mainPage.isAvatarPresent());

    }
}