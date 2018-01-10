package mainPageTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Test Case 4
 */

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class CreateNewApparat extends ParentTest {

    final String url = "http://v3.test.itpmgroup.com/login";
    final String login = "Student";
    final String password = "909090";
    final String apparatNumber = "0";
    final String apparatComment = "Не трогать этот аппарат";

    @Test
    public void successUserProfileUpdate() {

        //Создание аппарата
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        webDriver.get(url);
        webDriver.findElement(By.name("_username")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        webDriver.findElement(By.id("dictionary")).click();
        webDriver.findElement(By.xpath(".//a[@href='/dictionary/apparat']")).click();
        webDriver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/dictionary/apparat/edit']")).click();
        webDriver.findElement(By.id("apparat_apparatNumber")).sendKeys(apparatNumber);
        webDriver.findElement(By.id("apparat_apparatComment")).sendKeys(apparatComment);
        webDriver.findElement(By.xpath(".//button[@name='add']")).click();

        // Проверить, что в списке аппаратов есть аппарат с такими характеристиками:
        // Номер: 0
        // Комментарий: Не трогать этот аппарат

        webDriver.findElement(By.xpath(".//td[text()='Не трогать этот аппарат']")).click();
        webDriver.findElement(By.xpath(".//button[@name='delete']")).click();

        //Удаление аппарат
        webDriver.findElement(By.xpath(".//td[text()='Не трогать этот аппарат']")).click();
        webDriver.findElement(By.xpath(".//button[@name='delete']")).click();

    }

}