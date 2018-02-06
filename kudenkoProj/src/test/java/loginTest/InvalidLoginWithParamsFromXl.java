package loginTest;

import libs.SpreadsheetData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static pages.ParentPage.configProperties;

@RunWith(value = Parameterized.class)

public class InvalidLoginWithParamsFromXl extends ParentTest{
    String login, pass;

    public InvalidLoginWithParamsFromXl(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "login = {0} pass = {1}")
    public static Collection testData() throws IOException {
//        return Arrays.asList(new Object[][]{
//            {"Student", "111111"},
//            {"111111", "909090"}
//        });


        InputStream spreadsheet = new FileInputStream(
                configProperties.DATA_FILE_SUITE() + "testDataSuit.xls"
        );
        return new SpreadsheetData(spreadsheet, "InvalidLogon").getData();
    }

    @Test
    public void invalidLoginWithParams(){
        loginPage.loginUser(login, pass);
        Assert.assertFalse("User should not to be logged", mainPage.isAvatarPresent());
    }
}
