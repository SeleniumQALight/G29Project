package loginTest;


import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

public class LoginTestDB extends ParentTest {
    UtilsForDB utilsForDB =new UtilsForDB();


    @Test // это нужно для того чтобы чтобы запустить отдельно тест. не используя Main
    public void validLogin () throws SQLException, IOException, ClassNotFoundException {
        loginPage.loginUser("Student",utilsForDB.getPassForLogin("Student"));


       // webDriver.get("http://v3.test.itpmgroup.com"); // открываем ссылку сайта
       // webDriver.findElement(By.name("_username")).sendKeys("Student");// он ввел логин
        //webDriver.findElement(By.id("password")).sendKeys("909090");// он ввел пароль
//        loginPage.openLoginPage();
//        loginPage.enterTextIntoInputLogin("Student");
//        loginPage.enterTextIntoInputPass("909090");
//        loginPage.clickOnSubmitButton();
//        webDriver.findElement(By.id("password")).sendKeys("909090");
//        webDriver.findElement(By.xpath(".//button[@type='submit']")).click() ;// он нажал кнопку для того чтобы отправить логин

        Assert.assertTrue("Avatar is not present", // Assert-это способ сделать проверку сообщение покажется. если сообщение не тру.
                mainPage.isAvatarPresent() );






    }

}