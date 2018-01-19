package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin() {

        //webDriver.get("http://v3.test.itpmgroup.com");
        //webDriver.findElement(By.name("_username")).sendKeys("Student");
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();
        //webDriver.findElement(By.id("password")).sendKeys("909090");
        //webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());

    }

}
