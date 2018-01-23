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
        loginPage.validUserLogin(configProperties.valid_user_login(), configProperties.valid_user_password());
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();
        mainPage.deleteAllSparesWhenTheyArePresent(spareName);
        sparesPage.createNewSpare(spareName, spareTypeText);
        Assert.assertTrue("Created spare isn't present", sparesPage.isCreatedSpareIsPresent());
        sparesPage.deleteSpare(spareName);
    }
}
