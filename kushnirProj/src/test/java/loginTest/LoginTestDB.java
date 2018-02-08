package loginTest;


import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;


public class LoginTestDB extends ParentTest {
UtilsForDB utilForDB=
        new UtilsForDB();

    @Test//этот тест может быть запущен, будет типа как мейн, с него можно начать запуск
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {  //создаем метод

        //wait пробуй 10 секунд, получится-иди дальше

     //   webDriver.findElement(By.name("_username"))
             //   .sendKeys("Student");//.-следующая команда
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");

        webDriver.findElement(By.id("password"))
                .sendKeys(
                        utilForDB.getPassForLogin("Student"));
                ;//если пароль не будет правильным - до ассерта не дойдет, будет експешн(ПОЧЕМУ?)

        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent()//ждет что на входе будет тру. если тру-тест зеленый. если красный-тест фейл
                //синтакис - если будет фейл, будет сообщение
                //ассерт - способ сделать проверку


        );//видим аватарку-залогинились
    }


    }

