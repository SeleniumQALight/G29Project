package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    @Test
    public void addNewSpare(){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnSubmitButton();
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();


    }
}
