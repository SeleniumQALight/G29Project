package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class DeleteSpareTest extends ParentTest{

    @Test
    public void deleteSpare(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnSubmitButton();
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
        sparesPage.clickOnPlusButton();
        sparesPage.enterTextIntoSpareName("New Spare");
        sparesPage.chooseSpareType("Механика");
        sparesPage.clickOnSubmitSpareButton();

        sparesPage.clickOnAddedSpare();
        sparesPage.clickOnDeleteSpareButton();

    }

}
