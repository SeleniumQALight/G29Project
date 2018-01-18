package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest  extends ParentTest{

    @Test
    public void addNewSpare(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoOnputPass("909090");
        loginPage.clickOnSubmitButton();

        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubmenuSpare();
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        sparesPage.checkCurrentUrl();




    }
}
