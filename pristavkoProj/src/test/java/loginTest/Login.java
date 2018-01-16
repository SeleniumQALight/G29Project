package loginTest;

/**
 * Test Case 1
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Login extends ParentTest{

    final String url = "http://v3.test.itpmgroup.com/login";
    final String login = "Student";
    final String password = "909090";

    @Test
    public void vallidLogin() {

        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin(login);
        loginPage.enterTextIntoInputPassword(password);
/*
        webDriver.get(url);
        webDriver.findElement(By.name("_username")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);*/
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
        Assert.assertTrue("Menu is not present", mainPage.isMenuPresent());

    }

}