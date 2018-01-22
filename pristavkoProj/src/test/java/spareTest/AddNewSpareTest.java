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
        while (sparesPage.isCreatedSparePresetn() == true) {
            sparesPage.deleteSpare();
            continue;
        }
        sparesPage.createNewSpare();
        Assert.assertTrue("Created spare isn't present", sparesPage.isCreatedSpareIsPresent());
        sparesPage.deleteSpare();
    }
}
