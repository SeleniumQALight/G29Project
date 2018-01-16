package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() {

       // webDriver.get("http://v3.test.itpmgroup.com");
       // webDriver.findElement(By.name("_username")).sendKeys("Student");
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
//        webDriver.findElement(By.id("password")).sendKeys("909090");
//        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
    }

    //Assert - способ сделать проверку


}