package loginTest;

import Libs.ConfigProperties;
import Libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.util.Map;

import static pages.ParentPage.configProperties;

public class LoginTestExcel extends ParentTest{
    private ExcelDriver excelDriver;

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoImputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent());  //proverka - esli da - to ni4ego ne budet- esli net to vuvedet soobwenie

    }

    //@Test  //DZ
    //public void unValidLogin(){
     //   loginPage...
    //}

}
