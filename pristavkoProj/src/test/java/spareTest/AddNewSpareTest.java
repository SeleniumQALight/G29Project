package spareTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

public class AddNewSpareTest extends ParentTest {

    final String spareName = "Каляка Маляка";
    final String spareTypeText = "Датчики";

    @Test
    public void addNewSpare() {
        loginPage.loginUser(configProperties.user_login(), configProperties.user_password());
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();
        while ((sparesPage.isCreatedSpareIsPresent()) == true) {
            sparesPage.deleteSpare(spareName);
        }
        sparesPage.createNewSpare(spareName, spareTypeText);
        Assert.assertTrue("Created spare isn't present", sparesPage.isCreatedSpareIsPresent());
        sparesPage.deleteSpare(spareName);
    }
}
