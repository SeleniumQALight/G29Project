package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

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


