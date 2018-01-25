package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest  extends ParentTest{

    //imia zapchasti tut obijavit
    //HW  @Before - tut ischem est li element kotor my sozdali - v cikle proverial est li zapchast - imia zapchasti v teste dolgna byt
    //@After - udaliatm novyiu
    @Test
    public void addNewSpare(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubmenuSpare();
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }      deleted*/
        sparesPage.checkCurrentUrl();
        sparesPage.clickOnPlusButton();
        sparesPageEdit.checkCurrentUrl();
        sparesPageEdit.enterTextIntoNewSpareNameInput("testName");
        sparesPageEdit.enterTextIntoTipDetaliDropDown("Механика");
        sparesPageEdit.clickOnAddNewSpareButton();
        sparesPageEdit.checkCurrentUrl();


    }
}
