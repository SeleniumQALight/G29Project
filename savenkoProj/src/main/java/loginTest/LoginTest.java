package loginTest;

import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPages;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {


    @Test //этот тест может быть запущен отдельно, с него можно начать метод
    public void validLogin() {

        //webDriver.get("http://v3.test.itpmgroup.com");
        loginPage.openLoginPage();

        //webDriver.findElement(By.name("_username")).sendKeys("Student");
        loginPage.enterTextInputLogin("Student");

        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        Assert.assertTrue(
                "Avatar is not present",
                mainPage.isAvatarPresent()
                );
    }
}


