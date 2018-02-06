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

    @Test
    public void validLogin() throws IOException {
        Map data = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.loginUser(data.get("login").toString(), data.get("pass").toString());
        Assert.assertTrue("Avatar is not present", mainPage.isAvatarPresent() );
    }

}
