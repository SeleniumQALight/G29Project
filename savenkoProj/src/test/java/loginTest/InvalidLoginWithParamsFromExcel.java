package loginTest;

import libs.SpreadsheetData;
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

@RunWith(value = Parameterized.class) //should run with a few parameters

public class InvalidLoginWithParamsFromExcel extends ParentTest{
    String login, pass;

    public InvalidLoginWithParamsFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;

    }
    @Parameterized.Parameters (name = "login = {0} pass = {1}")
    public static Collection testData () throws IOException { //в этом методе может возникнуть этот эксепшн
//        return Arrays.asList(new Object [] [] {
//                {"Student", "111111"},
//                {"1111111", "534533"}
//        });
        InputStream spreadsheet = new FileInputStream(
                configProperties.DATA_FILE_SUITE() + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
        }



    @Test
    public void InvalidLoginWithParams () {
        loginPage.loginUser(login, pass);
        Assert.assertFalse("User should not be logged",
                mainPage.isAvatarPresent());
    }



}
