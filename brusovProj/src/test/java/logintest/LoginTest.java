package logintest;


import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;


public class LoginTest extends ParentTest {


    @Test
    public void vallidLogin() {

        //webDriver.get("http://v3.test.itpmgroup.com/login");
        //webDriver.findElement(By.name("_username")).sendKeys("Student");

//        loginPage.openLoginPage();
//        loginPage.enterTextintoInputLogin("Student");
//        webDriver.findElement(By.id("password")).sendKeys("909090");
//        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
//        loginPage.enterTextIntoInputPsss("909090");
//        loginPage.clickOnSubmitButton();

        loginPage.loginUser("Student", "909090");

        Assert.assertTrue("Avatar is not present",
                mainPage.isAvatarPresent());


    }
}

