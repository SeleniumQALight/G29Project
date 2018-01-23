package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ParentTest{


    // можно запустить без мейн метода (заимпортить junit)
    @Test
    public void validLogin(){
        //webDriver.get("http://v3.test.itpmgroup.com"); //otkrivaem url
        //webDriver.findElement(By.name("_username")).sendKeys("Student"); //nahodim pole login i vvodim v nego dannue
        loginPage.openLoginPage();
        loginPage.enterTextIntoImputLogin("Student");
       // webDriver.findElement(By.id("password")).sendKeys("909090");// toge samoe s parolem
       // webDriver.findElement(By.xpath(".//button[@type='submit']")).click(); //nahodim knopky submit i nagimaem
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());  //proverka - esli da - to ni4ego ne budet- esli net to vuvedet soobwenie

    }

    //@Test  //DZ
    //public void unValidLogin(){
     //   loginPage...
    //}

}
