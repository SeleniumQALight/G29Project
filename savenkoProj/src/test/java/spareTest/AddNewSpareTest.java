package spareTest;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    @Test
    public void AddNewSpare  () {
        loginPage.loginUser("Student", "909090");
        mainPage.checkCurrentUrl();  //mainPage.isAvatarPresent();
        mainPage.clickOnMenuDictionary();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickOnSubMenuSpares();
        sparePage.checkCurrentUrl();
        sparePage.clickOnAddButton();
    }

}
