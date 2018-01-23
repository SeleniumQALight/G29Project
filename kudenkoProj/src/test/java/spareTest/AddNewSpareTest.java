package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{

    @Test
    public void addNewSpare(){
        loginPage.loginUser("student", "909090");
        mainPage.checkCurrentUlr();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMuneSpare();
        sparePage.checkCurrentUlr();
        while(sparePage.createdSparePresent()){
            sparePage.clickOnCreatedSpare();
            sparePage.deleteCreatedSpareElement();
        }
        sparePage.clickPlusButton();
        sparePage.enterSpareName("TEST");
        sparePage.setSpareTypeSelect("Датчики");
        sparePage.clickCreateSpareButton();
        sparePage.clickOnCreatedSpare();
        sparePage.deleteCreatedSpareElement();
        sparePage.isAllCreatedElementsDeleted();
    }
}
