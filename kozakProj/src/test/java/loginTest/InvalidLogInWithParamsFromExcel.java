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

@RunWith(value = Parameterized.class)                //вказуємо, що цей потрібно буде запустити з декількома параметрами

public class InvalidLogInWithParamsFromExcel extends ParentTest {
    String login, password;

    public InvalidLogInWithParamsFromExcel(String login, String password) {        //конструктор закидує дані
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "login ={0} pass = {1}")                    //блок, що дає нам параметри
    public static Collection testData() throws IOException {
//    return Arrays.asList(new Object[][]{
//            {"Student","111111"},
//            {"qqqqgfq","909090"},
//            {"",""}
//    });
        InputStream spreadsheet = new FileInputStream(                     // підєднали наш файл
                configProperties.DATA_FILE_SUITE() + "testDataSuit.xls"       // прописали шлях до нашого файла
        );
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();  //куда піти і що взяти

    }

    @Test
    public void invalidLogInWithParams() {
        loginPage.loginUser(login, password);
        Assert.assertTrue("User should not be logged ", loginPage.authorizationFormIsPresent());
    }
}
