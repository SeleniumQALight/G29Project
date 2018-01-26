package logintest;


import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;


public class LoginTestExcel extends ParentTest {
    private ExcelDriver excelDriver;

    @Test
    public void vallidLogin() throws IOException {
        Map data=excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        //webDriver.get("http://v3.test.itpmgroup.com/login");
        //webDriver.findElement(By.name("_username")).sendKeys("Student");

//        loginPage.openLoginPage();
//        loginPage.enterTextintoInputLogin("Student");
//        webDriver.findElement(By.id("password")).sendKeys("909090");
//        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
//        loginPage.enterTextIntoInputPsss("909090");
//        loginPage.clickOnSubmitButton();
        //loginPage.loginUser("Student", "909090");
        loginPage.loginUser(data.get("login").toString(),data.get("pass").toString());
        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent());


    }
}

