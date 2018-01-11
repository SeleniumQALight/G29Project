package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParenTest;

public class LoginTest extends ParenTest{

    @Test
    public void validLogin(){
        //webDriver.get("http://v3.test.itpmgroup.com");
        //webDriver.findElement(By.name("_username"))
          //      .sendKeys("Student");
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");

//        webDriver.findElement(By.id("password"))
//                .sendKeys("909090");
//        webDriver.findElement(By.xpath(".//button[@type='submit']"))
//                .click();

        loginPage.enterTextIntoToInputPassword("909090");
        loginPage.clickOnSubmitButton();
        mainPage.isAvatarPresent();
    }

}
