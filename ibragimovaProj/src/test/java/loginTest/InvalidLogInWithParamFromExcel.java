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

@RunWith(value = Parameterized.class)


public class InvalidLogInWithParamFromExcel extends ParentTest{
    String login,pass;

    public InvalidLogInWithParamFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    @Parameterized.Parameters (name = "login={0} pass = {1}") // это блок который будет давать нам параметры, ран нашего теста//верни нам масив данніх
     public static Collection testData () throws IOException {
//        return Arrays.asList(new Object[][]{
//                { "Student", "11111"},{"11111","909090"}
//        });}
        InputStream spreadheet = new FileInputStream( // установили коннект к файлу
                configProperties.DATA_FILE_SUITE() + "testDataSuit.xls" // путь к файлу
        );
        return new SpreadsheetData(spreadheet,"InvalidLogOn").getData();

    }
    @Test
    public void invalidLogInWithParam(){
        loginPage.loginUser(login,pass);
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());
    }
}
