package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import parentTest.ParentTest;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {
    @Test
    public void validLogin(){
      //  webDriver.get("http://v3.test.itpmgroup.com/login");
        //webDriver.findElement(By.name("_username")).sendKeys("Student");
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

//Assert sposob sledat proverky
        Assert.assertTrue("Avatar in not present", mainPage.isAvatarPresent());
    }
}
