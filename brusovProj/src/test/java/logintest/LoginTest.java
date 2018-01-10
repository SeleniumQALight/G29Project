package logintest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parrentTest.ParrentTest;
import java.util.concurrent.TimeUnit;


public class LoginTest extends ParrentTest {


    @Test
    public void vallidLogin() {

      //webDriver.get("http://v3.test.itpmgroup.com/login");
      //webDriver.findElement(By.name("_username")).sendKeys("Student");

        loginPage.openLoginPage();
        loginPage.enterTextintoInputLogin("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent());

    }
}

