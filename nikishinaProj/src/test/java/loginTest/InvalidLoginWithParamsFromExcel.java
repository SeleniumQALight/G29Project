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
public class InvalidLoginWithParamsFromExcel extends ParentTest {
    String login, pass;

    public InvalidLoginWithParamsFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "login = {0}, pass = {1}")
    public static Collection testData () throws IOException {
//        return Arrays.asList(new Object[][]{
//                {"Student", "11111"},
//                {"", "11111"},
//                {"11111", "909090"}
//        });
//        сначала достучимся к файлику с тестовыми данными (установим связь с ним - это инпут стрим:
        InputStream spreadsheet = new FileInputStream(
                configProperties.DATA_FILE_SUITE()+"testDataSuit.xls" //взяли с пропертей путь к папке и прописали путь к файлу
        );
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();//обратились к классу, возвращаем новый объект класса SpreadsheetData:
        // путь к файлу и название самого листа в книге эксель
    }

    @Test
    public void invalidLoginWithParams (){
        loginPage.loginUser(login, pass);
        Assert.assertFalse("User shouldn't be logged in", mainPage.isAvatarPresent());
    }
}
