package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentClass;

import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentClass {

    @Test //этот тест может быть запущен (JUnit с аннотацией)
    public void validLogin() {

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//пробуй каждые полсекунды сделать это на протяжении 10 секунд
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());
    }

    //Assert - способ сделать проверку


}