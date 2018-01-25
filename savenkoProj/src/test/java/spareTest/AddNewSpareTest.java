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
        spareDictionaryPage.checkCurrentUrl();
        String generatedSpareName = spareDictionaryPage.enterSpareName();
        spareDictionaryPage.enterSpareDetailType();
        spareDictionaryPage.clickOnCreateButton();
        sparePage.checkCurrentUrl();
        sparePage.clickOnNewSpareElement(generatedSpareName);
        spareDictionaryPage.clickOnDeleteButton();


    }

}
