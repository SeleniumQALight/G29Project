package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {

    @Test
    public void addNewSpare() {
        loginPage.loginUser("Student", "909090");
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
    }
}
