package loginTest;


import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;

public class LoginTestExcel extends ParentTest {
    private ExcelDriver excelDriver;


    @Test // это нужно для того чтобы чтобы запустить отдельно тест. не используя Main
    public void validLogin () throws IOException {
        Map data=excelDriver.getData( configProperties.DATA_FILE(),"validLogOn");//obyavili peremennuu,kotoroi na vhod mi dali dannie i dali put`
        loginPage.loginUser(data.get("login").toString(),data.get("pass").toString());
        Assert.assertTrue("Avatar is not present", // Assert-это способ сделать проверку сообщение покажется. если сообщение не тру.
                mainPage.isAvatarPresent() );






    }

}
