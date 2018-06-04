package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin() {
        // webDriver.get("http://v3.test.itpmgroup.com");
        // webDriver.findElement(By.name("_username")).sendKeys("Student");
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        // webDriver.findElement(By.name("_password")).sendKeys("909090");
        // webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        Assert.assertTrue("Avatar in not present", mainPage.isAvatarPresent());
    }
}
