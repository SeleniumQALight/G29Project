package spareTest;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    @Test
    public void AddNewSpare  () {
        loginPage.loginUser("Student", "909090");
        mainPage.checkCurrentUrl();  //mainPage.isAvatarPresent();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpares();
        sparePage.checkCurrentUrl();
        sparePage.clickOnAddButton();
    }

}
