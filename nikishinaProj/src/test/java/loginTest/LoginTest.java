package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import parentTest.ParentTest;
import java.util.concurrent.TimeUnit;


public class LoginTest extends ParentTest{

    @Test //заимпортили аннотация JUnit
    public void validLogin(){ //этот метод является телом тест-кейса

//        webDriver.get("http://v3.test.itpmgroup.com"); //переходим по урлу
//        webDriver.findElement(By.name("_username")).sendKeys("Student");

        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin ("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

//        webDriver.findElement(By.id("password")).sendKeys("909090");
//        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        //теперь пишем проверку, а действительно ли мы залогинились, ассерт выбираем junit(org.junit)
        //ассерт - это способ сделать проверку. работает так: если это то, что он ждет (в данной ситуации ждет булево значение тру),
        // то тест проходит, а если не то, что надо, то выводит сообщение, которое мы указали перед действием файнд элемент
        //для того, чтобы проверить, выводится ли сообщение об ошибке, в случае отсутствия аватара, делаем инверсию -
        //то есть проверяем ассерт.фолс. Чтобы ее сделать, перед ассерт.тру надо поставить восклицательный знак

        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent());
    }

// 4.  Написать тест по проверке функционала логина с невалидными данными (используя степ с пункта 3)
// (использовать один набор данных , например notValidLogin  и notValidPass)
    @Test
    public void inValidLogin (){
        loginPage.loginUser("909090", "Student");
        Assert.assertFalse("Avatar is present",
                mainPage.isAvatarPresent());
    }
// можно было сделать проверку ассерт на то, что мы остались на странице авторизации с помощью метода isLoginInputDisplay

}
