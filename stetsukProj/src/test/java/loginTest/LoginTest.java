package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {


    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() {

//        webDriver.get("http://v3.test.itpmgroup.com");
//        webDriver.findElement(By.name("_username")).sendKeys("student");
        loginPage.openLoginPage();
        loginPage.enterTextIntuInputLogin("student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Avator is not present", mainPage.isAvatarPresent());

    }

}