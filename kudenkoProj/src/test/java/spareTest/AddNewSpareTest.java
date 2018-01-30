package spareTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    final String SPARE_NAME = "TEST";
    final String SPARE_TYPE = "Датчики";
    @Before
    public void prepareAddNewSpare(){
        loginPage.loginUser("student", "909090");
        mainPage.checkCurrentUlr();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMuneSpare();
        sparePage.checkCurrentUlr();
        while(sparePage.createdSparePresent(SPARE_NAME)) {
            sparePage.clickOnCreatedSpare(SPARE_NAME);
            sparePage.deleteCreatedSpareElement();
        }
    }

    @Test
    public void addNewSpare(){
        loginPage.openLoginPage();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMuneSpare();
        sparePage.checkCurrentUlr();
        sparePage.clickPlusButton();
        sparePage.enterSpareName(SPARE_NAME);
        sparePage.setSpareTypeSelect(SPARE_TYPE);
        sparePage.clickCreateSpareButton();
        sparePage.checkSpareWasCreated(SPARE_NAME);
    }

    @After
    public void deleteCreatedElement(){
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMuneSpare();
        sparePage.checkCurrentUlr();
        if(sparePage.createdSparePresent(SPARE_NAME)){
            sparePage.clickOnCreatedSpare(SPARE_NAME);
            sparePage.deleteCreatedSpareElement();
            sparePage.isAllCreatedElementsDeleted(SPARE_NAME);
        }
    }
}
