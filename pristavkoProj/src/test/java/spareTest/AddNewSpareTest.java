package spareTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {

    @Test
    public void addNewSpare() {
        loginPage.loginUser();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();
        sparesPage.createNewSpare();
        waitTimeWhenLoadingPage.WaitTimeWhenLoadingPage();
        Assert.assertTrue("Created spare isn't present", sparesPage.isCreatedSpareIsPresent());
    }
}
