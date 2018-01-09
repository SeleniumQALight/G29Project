package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;


public class LoginTest extends ParentTest {


    @Test                                                                     // main  тепер не потрібен, джЮнфт все сам зробив (Він створює структуру)
    public void validLogin() {

  //     webDriver.get("http://v3.test.itpmgroup.com");                         // загрузить силку
  //     webDriver.findElement(By.name("_username")).sendKeys("Student");

        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();


        Assert.assertTrue("Avatar is not present",                              //Асерт - частина Junit, використовується для провірки.
                mainPage.isAvatarPresent());
    }


}
