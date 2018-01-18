package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{

    @Test
    public void addNewSpare(){
        loginPage.loginUser("student", "909090");
        mainPage.checkCurrentUlr();
        mainPage.clickOnMenuDictionary();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickOnSubMuneSpare();
        sparePage.checkCurrentUlr();
        sparePage.clickPlusButton();
        sparePage.enterSpareName("TEST");
        sparePage.setSpareTypeSelect("Датчики");
        sparePage.clickCreateSpareButton();
    }
}
