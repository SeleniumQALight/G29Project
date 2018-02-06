package loginTest;


import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;


public class LoginTestExcel extends ParentTest {
    private ExcelDriver excelDriver;

    @Test//этот тест может быть запущен, будет типа как мейн, с него можно начать запуск
  public void validLogin() throws IOException {
        Map data = excelDriver.getData(configProperties.DATA_FILE(),"validLogoOn");
        loginPage.loginUser(data.get("login").toString(),data.get("password").toString()
                );
        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent());//объявили переменную
        //когда выполнится строка будет ключ-значение. в гетдата прошито браь кей с первой колоонки, а [] со второй
    }


    }

